package com.baocheng.service.vo;

/**
 * @description: summary relative car's sum of stock
 * @author: Atimynyc
 * @Date: 2021/11/7
 **/
public class CarStockSumVO {

    private String carTypeName;

    private String carType;

    private Integer stockNum;

    public String getCarTypeName() {
        return carTypeName;
    }

    public void setCarTypeName(String carTypeName) {
        this.carTypeName = carTypeName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }
}
