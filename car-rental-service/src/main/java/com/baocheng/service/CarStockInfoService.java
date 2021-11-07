package com.baocheng.service;

import com.baocheng.pojo.CarStockInfo;

import java.util.List;

public interface CarStockInfoService {

    List<CarStockInfo> getCardStockInfoListByStatus(String status);

    CarStockInfo getACarFromStockByType(String carType);

}
