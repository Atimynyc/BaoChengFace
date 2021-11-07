package com.baocheng.mapper;

import com.baocheng.my.mapper.MyMapper;
import com.baocheng.pojo.CarStockInfo;

import java.util.List;

public interface CarStockInfoMapper extends MyMapper<CarStockInfo> {

    List<CarStockInfo> getCarStockInfoListByCarStatus(String carStatus);

    CarStockInfo getACarFromStock(String carType);

}