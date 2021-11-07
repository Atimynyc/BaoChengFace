package com.baocheng.mapper;

import com.baocheng.my.mapper.MyMapper;
import com.baocheng.pojo.CarStockInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CarStockInfoMapper extends MyMapper<CarStockInfo> {

    List<CarStockInfo> getCarStockInfoListByCarStatus(String carStatus);

    CarStockInfo getACarFromStock(String carType);

    Integer updateCardStockStatus(@Param("paramsMap") Map<String, Object> map);

}