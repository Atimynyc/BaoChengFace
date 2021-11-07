package com.baocheng.service.impl;

import com.baocheng.pojo.CarStockInfo;
import com.baocheng.pojo.UserRentalRecord;
import com.baocheng.service.CarRentalService;
import com.baocheng.service.CarStockInfoService;
import com.baocheng.service.UserRentalRecordService;
import com.baocheng.service.common.BCJSONResult;
import com.baocheng.service.enums.CarStatusEnum;
import com.baocheng.service.enums.RentalStatusEnum;
import com.baocheng.service.vo.CarStockSumVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class CarRentalServiceImpl implements CarRentalService{

    @Autowired
    private CarStockInfoService carStockInfoService;
    @Autowired
    private UserRentalRecordService userRentalRecordService;

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
            carStockSumVO.setStockNum(carStockSumMap.get(key));
            carStockSumVOList.add(carStockSumVO);
        }

        return carStockSumVOList;
    }


    @Override
    public BCJSONResult rentalCar(String userId, String carType) {

        try {
            Date nowDate = new Date();
            // 1. try to get one car from car stock by carType
            CarStockInfo carStockInfo = carStockInfoService.getACarFromStockByType(carType);
            if (carStockInfo == null) {
                return BCJSONResult.errorMsg("The car of your choice is out of stock, pls try other car");
            }

            // 2. new add user rental car record
            UserRentalRecord userRentalRecord = new UserRentalRecord();
            userRentalRecord.setUserId(userId);
            userRentalRecord.setCarId(carStockInfo.getId().toString());
            userRentalRecord.setRentalStatus(RentalStatusEnum.IN_TRADIN.getRentalStatus());
            userRentalRecord.setCreateTime(nowDate);
            userRentalRecord.setUpdateTime(nowDate);
            userRentalRecordService.insertUserRentalRecord(userRentalRecord);

            // 3.


        } catch (Exception e) {
            e.printStackTrace();
        }
        return BCJSONResult.ok();
    }
}
