package com.baocheng.service.bo;

/**
 * @description:
 * @author: Atimynyc
 * @Date: 2021/11/7
 **/
public class CarRentalBO {

    private String userId;

    private String carType;

    private String carId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }
}
