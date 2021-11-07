package com.baocheng.service.impl;

import com.baocheng.pojo.CarStockInfo;
import com.baocheng.pojo.UserRentalRecord;
import com.baocheng.service.CarRentalService;
import com.baocheng.service.CarStockInfoService;
import com.baocheng.service.UserRentalRecordService;
import com.baocheng.service.common.BCJSONResult;
import com.baocheng.service.enums.CarStatusEnum;
import com.baocheng.service.enums.CarTypeNameEnum;
import com.baocheng.service.enums.RentalStatusEnum;
import com.baocheng.service.vo.CarStockSumVO;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CarRentalServiceImpl implements CarRentalService{

    @Autowired
    private CarStockInfoService carStockInfoService;
    @Autowired
    private UserRentalRecordService userRentalRecordService;
    @Autowired
    private Sid sid;

    @Override
    public List<CarStockSumVO> getCarStockInfo() {

        List<CarStockInfo> carStockInfoList = carStockInfoService.getCardStockInfoListByStatus(CarStatusEnum.IN_STOCK.getCarStatus());

        Map<String, Integer> carStockSumMap = new HashMap<>();
        for (CarStockInfo carStockInfo : carStockInfoList) {
            String carType = carStockInfo.getCartype();
            Integer sum = carStockSumMap.get(carType);
            if (sum == null) {
                carStockSumMap.put(carType, 1);
            } else {
                carStockSumMap.put(carType, ++sum);
            }
        }

        List<CarStockSumVO> carStockSumVOList = new ArrayList<>();
        for (String key : carStockSumMap.keySet()) {
            CarStockSumVO carStockSumVO = new CarStockSumVO();
            carStockSumVO.setCarType(key);
            carStockSumVO.setCarTypeName(CarTypeNameEnum.getTypeNameByType(key));
            carStockSumVO.setStockNum(carStockSumMap.get(key));
            carStockSumVOList.add(carStockSumVO);
        }

        return carStockSumVOList;
    }


    @Override
    public BCJSONResult rentalCar(String userId, String carType) {
        // 1. try to get one car from car stock by carType
        CarStockInfo carStockInfo = carStockInfoService.getACarFromStockByType(carType);
        if (carStockInfo == null) {
            return BCJSONResult.errorMsg("The car of your choice is out of stock, pls try other car");
        }
        String carId = carStockInfo.getId().toString();
        String recordId = sid.nextShort();
        try {
            Date nowDate = new Date();

            // 2. new add user rental car record
            UserRentalRecord userRentalRecord = new UserRentalRecord();
            userRentalRecord.setRecordId(recordId);
            userRentalRecord.setUserId(userId);
            userRentalRecord.setCarId(carId);
            userRentalRecord.setRentalStatus(RentalStatusEnum.IN_TRADIN.getRentalStatus());
            userRentalRecord.setCreateTime(nowDate);
            userRentalRecord.setUpdateTime(nowDate);
            userRentalRecordService.insertUserRentalRecord(userRentalRecord);

            this.startRentalCar(carId, recordId);
        } catch (Exception e) {
            e.printStackTrace();
            userRentalRecordService.updateUserRentalStatusRecordByRecordId(
                    RentalStatusEnum.RENTAL_FAIL.getRentalStatus(), recordId);

            return BCJSONResult.errorException("system_error");
        }

        return BCJSONResult.ok(carStockInfoService.getCarStockInfoById(carId));
    }

    @Override
    public BCJSONResult returnCar(String userId, String carId) {

        CarStockInfo carStockInfo = carStockInfoService.getCarStockInfoById(carId);
        if (carStockInfo == null) {
            return BCJSONResult.errorMsg("could not found the car's information");
        }

        UserRentalRecord userRentalRecord = userRentalRecordService.selectRecordByUserIdCarIdAndStatus(userId,
                carId, RentalStatusEnum.RENTAL_SUCCESS.getRentalStatus());
        if (userRentalRecord == null) {
            return BCJSONResult.errorMsg("could not found user's rental record");
        }

        String recordId = userRentalRecord.getRecordId();

        try {
            // 1. enter return flow
            userRentalRecordService.updateUserRentalStatusRecordByRecordId(
                    RentalStatusEnum.IN_THE_BACK.getRentalStatus(), recordId);

            //2. start change car status from in_rental to in_stock
            this.startReturnCar(carId, recordId);
        } catch (Exception e) {
            e.printStackTrace();
            userRentalRecordService.updateUserRentalStatusRecordByRecordId(
                    RentalStatusEnum.RETURN_FAIL.getRentalStatus(), recordId);

            return BCJSONResult.errorException("system_error");
        }

        return BCJSONResult.ok();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void startRentalCar(String carId, String recordId) {
        // 1. start change car status from in_stock to in_rental
        carStockInfoService.updateCardStockStatus(carId, CarStatusEnum.IN_RENTAL.getCarStatus());

        // 2. change user rental status
        userRentalRecordService.updateUserRentalStatusRecordByRecordId(
                RentalStatusEnum.RENTAL_SUCCESS.getRentalStatus(), recordId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void startReturnCar(String carId, String recordId) {
        // 1. start change car status from in_stock to in_rental
        carStockInfoService.updateCardStockStatus(carId, CarStatusEnum.IN_STOCK.getCarStatus());

        // 2. change user rental status
        userRentalRecordService.updateUserRentalStatusRecordByRecordId(
                RentalStatusEnum.RETURN_SUCCESS.getRentalStatus(), recordId);
    }

}
