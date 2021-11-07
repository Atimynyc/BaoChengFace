package com.baocheng.service.vo;



import java.util.List;

/**
 * @description: car stock infomation
 * @author: Atimynyc
 * @Date: 2021/11/7
 **/
public class CarStockInfoVO {

    public List<CarStockSumVO> carStockSumVOList;

    public List<CarStockSumVO> getCarStockInfoList() {
        return carStockSumVOList;
    }

    public void setCarStockInfoList(List<CarStockSumVO> carStockSumVOList) {
        this.carStockSumVOList = carStockSumVOList;
    }
}
