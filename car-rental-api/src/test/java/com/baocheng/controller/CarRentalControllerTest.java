package com.baocheng.controller;

import com.baocheng.Application;
import com.baocheng.service.bo.CarRentalBO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)//项目启动类
public class CarRentalControllerTest {

    @Autowired
    private CarRentalController carRentalController;

    @Test
    public void searchStockInfo() throws Exception {

        System.out.println(carRentalController.searchStockInfo().getData().toString());

    }

    @Test
    public void rentalCar() throws Exception {
        CarRentalBO carRentalBO = new CarRentalBO();
        carRentalBO.setCardType("1");
        carRentalBO.setUserId("1");
        carRentalController.rentalCar(carRentalBO);

    }

}