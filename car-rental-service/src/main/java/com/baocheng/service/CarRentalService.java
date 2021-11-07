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

    /**
     * search car stock list
     * @return
     */
    List<CarStockSumVO> getCarStockInfo();

    /**
     * rental car
     * @param userId
     * @param carType
     * @return
     */
    BCJSONResult rentalCar(String userId, String carType);

    /**
     * return car
     * @param userId
     * @param carId
     * @return
     */
    BCJSONResult returnCar(String userId, String carId);

}
