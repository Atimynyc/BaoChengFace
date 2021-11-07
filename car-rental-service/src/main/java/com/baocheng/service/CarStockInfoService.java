package com.baocheng.service;

import com.baocheng.pojo.CarStockInfo;

import java.util.List;

public interface CarStockInfoService {

    List<CarStockInfo> getCardStockInfoListByStatus(String status);

    CarStockInfo getACarFromStockByType(String carType);

    Integer updateCardStockStatus(String carId, String status);

    CarStockInfo getCarStockInfoById(String carId);
}
