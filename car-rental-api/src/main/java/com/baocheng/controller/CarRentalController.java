package com.baocheng.controller;


import com.baocheng.service.CarRentalService;
import com.baocheng.service.bo.CarRentalBO;
import com.baocheng.service.common.BCJSONResult;
import com.baocheng.service.vo.CarStockSumVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: car rental controller
 * @author: Atimynyc
 * @Date: 2021/11/7
 **/
@RequestMapping("carrental")
@RestController
public class CarRentalController {

    @Autowired
    private CarRentalService carRentalService;

    @PostMapping("/searchStockInfo")
    public BCJSONResult searchStockInfo() {

        List<CarStockSumVO> carStockSumVOList = carRentalService.getCarStockInfo();
        return BCJSONResult.ok(carStockSumVOList);
    }


    @PostMapping("/rentalCar")
    public BCJSONResult rentalCar(@RequestBody CarRentalBO carRentalBO) {
        return carRentalService.rentalCar(carRentalBO.getUserId(), carRentalBO.getCardType());
    }

}
