package com.baocheng.service.enums;

/**
 * @description:
 * @author: Atimynyc
 * @Date: 2021/11/7
 **/
public enum RentalStatusEnum {
    IN_TRADIN("1"),
    RENTAL_SUCCESS("2"),
    RENTAL_FAIL("3"),
    IN_THE_BACK("4"),
    RETURN_SUCCESS("5"),
    RETURN_FAIL("6");

    private final String rentalStatus;

    RentalStatusEnum(String rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public String getRentalStatus() {
        return rentalStatus;
    }
}
