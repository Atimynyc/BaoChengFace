package com.baocheng.service.impl;

import com.baocheng.mapper.CarStockInfoMapper;
import com.baocheng.pojo.CarStockInfo;
import com.baocheng.service.CarStockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarStockInfoServiceImpl implements CarStockInfoService{

    @Autowired
    private CarStockInfoMapper carStockInfoMapper;

    @Override
    public List<CarStockInfo> getCardStockInfoListByStatus(String status) {
        return carStockInfoMapper.getCarStockInfoListByCarStatus(status);
    }

    @Override
    public CarStockInfo getACarFromStockByType(String carType) {
        return carStockInfoMapper.getACarFromStock(carType);
    }

    @Override
    public Integer updateCardStockStatus(String carId, String status) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("status", status);
        paramsMap.put("id", Integer.parseInt(carId));
        return carStockInfoMapper.updateCardStockStatus(paramsMap);
    }

    @Override
    public CarStockInfo getCarStockInfoById(String carId) {
        return carStockInfoMapper.selectByPrimaryKey(Integer.parseInt(carId));
    }
}
