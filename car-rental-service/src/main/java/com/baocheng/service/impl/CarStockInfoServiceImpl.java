package com.baocheng.service.impl;

import com.baocheng.mapper.CarStockInfoMapper;
import com.baocheng.pojo.CarStockInfo;
import com.baocheng.service.CarStockInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
}
