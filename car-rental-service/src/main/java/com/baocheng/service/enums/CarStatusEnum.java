package com.baocheng.service.enums;

/**
 * @description: car status enum
 * @author: Atimynyc
 * @Date: 2021/11/7
 **/
public enum CarStatusEnum {

    IN_STOCK("1"),
    IN_RENTAL("2");

    private final String carStatus;

    CarStatusEnum(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getCarStatus() {
        return carStatus;
    }
}
