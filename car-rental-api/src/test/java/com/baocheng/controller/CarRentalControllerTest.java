package com.baocheng.controller;

import com.baocheng.Application;
import com.baocheng.service.bo.CarRentalBO;
import com.baocheng.service.common.BCJSONResult;
import com.baocheng.service.common.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)//项目启动类
public class CarRentalControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(CarRentalControllerTest.class);

    @Autowired
    private CarRentalController carRentalController;

    // test get car stock info
    @Test
    public void searchStockInfo() throws Exception {
        logger.info(JsonUtils.objectToJson(carRentalController.searchStockInfo().getData()));
    }

    // test rental one car
    @Test
    public void rentalCar() throws Exception {
        CarRentalBO carRentalBO = new CarRentalBO();
        carRentalBO.setCarType("1");
        carRentalBO.setUserId("1");
        BCJSONResult bcjsonResult = carRentalController.rentalCar(carRentalBO);
        System.out.println("end");
    }

    // test return car but not rental car yet
    @Test
    public void returnCar() throws Exception {
        CarRentalBO carRentalBO = new CarRentalBO();
        carRentalBO.setUserId("1");
        carRentalBO.setCarId("1");
        carRentalController.returnCar(carRentalBO);
    }

    // test rental car out of stock
    @Test
    public void test1() throws Exception {
        CarRentalBO carRentalBO = new CarRentalBO();
        carRentalBO.setCarType("1");
        carRentalBO.setUserId("1");
        carRentalController.rentalCar(carRentalBO);
        carRentalController.rentalCar(carRentalBO);
        // stock is 2, when third time to rental car , will remind you to choose other car
        carRentalController.rentalCar(carRentalBO);
    }

    // test rental car which car type is not exist
    @Test
    public void test2() throws Exception {
        CarRentalBO carRentalBO = new CarRentalBO();
        // car type = 3 is not exist, will remind you to choose other car
        carRentalBO.setCarType("3");
        carRentalBO.setUserId("1");
        carRentalController.rentalCar(carRentalBO);
    }

    // test rental two same type car and return one car
    // then you can continue rental the same type car
    @Test
    public void test3() throws Exception {
        CarRentalBO carRentalBO = new CarRentalBO();
        carRentalBO.setCarType("1");
        carRentalBO.setUserId("1");
        carRentalController.rentalCar(carRentalBO);
        carRentalController.rentalCar(carRentalBO);
        CarRentalBO returnRentalBO = new CarRentalBO();
        returnRentalBO.setCarId("1");
        returnRentalBO.setUserId("1");
        // return one car
        carRentalController.returnCar(returnRentalBO);
        // can still rental the same car
        carRentalController.rentalCar(carRentalBO);
    }

    // test two customer rental car at same time
    @Test
    public void test4() throws Exception {
        CarRentalBO firstCustomer = new CarRentalBO();
        firstCustomer.setCarType("1");
        firstCustomer.setUserId("1");
        carRentalController.rentalCar(firstCustomer);
        CarRentalBO secondCustomer = new CarRentalBO();
        secondCustomer.setCarType("1");
        secondCustomer.setUserId("2");
        carRentalController.rentalCar(firstCustomer);
        // this time could not rental success
        carRentalController.rentalCar(firstCustomer);
    }

}