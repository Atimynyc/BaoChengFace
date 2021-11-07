package com.baocheng.service.enums;

public enum CarTypeNameEnum {
    TOYOTA_GAMRY("1", "TOYOTA_GAMRY"),
    BMW_650("2", "BMW_650");

    private final String carType;

    private final String carName;

    CarTypeNameEnum(String carType, String carName) {
        this.carType = carType;
        this.carName = carName;
    }

    public String getCarType() {
        return carType;
    }

    public String getCarName() {
        return carName;
    }

    public static String getTypeNameByType(String carType) {
        for (CarTypeNameEnum carTypeNameEnum : CarTypeNameEnum.values()) {
            if (carTypeNameEnum.getCarType().equals(carType)) {
                return carTypeNameEnum.getCarName();
            }
        }
        return "";
    }

}
