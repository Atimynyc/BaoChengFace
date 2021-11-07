package com.baocheng.service;

import com.baocheng.service.common.BCJSONResult;
import com.baocheng.service.vo.CarStockSumVO;

import java.util.List;

/**
 * @description: car rental handle service
 * @author: Atimynyc
 * @Date: 2021/11/7
 **/
public interface CarRentalService {

    List<CarStockSumVO> getCarStockInfo();

    BCJSONResult rentalCar(String userId, String carType);

}
