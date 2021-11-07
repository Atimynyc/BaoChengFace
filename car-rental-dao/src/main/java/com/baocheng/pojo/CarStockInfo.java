package com.baocheng.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "car_stock_info")
public class CarStockInfo {
    @Id
    private Integer id;

    @Column(name = "carName")
    private String carname;

    @Column(name = "carType")
    private String cartype;

    @Column(name = "carStatus")
    private String carstatus;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return carName
     */
    public String getCarname() {
        return carname;
    }

    /**
     * @param carname
     */
    public void setCarname(String carname) {
        this.carname = carname;
    }

    /**
     * @return carType
     */
    public String getCartype() {
        return cartype;
    }

    /**
     * @param cartype
     */
    public void setCartype(String cartype) {
        this.cartype = cartype;
    }

    /**
     * @return carStatus
     */
    public String getCarstatus() {
        return carstatus;
    }

    /**
     * @param carstatus
     */
    public void setCarstatus(String carstatus) {
        this.carstatus = carstatus;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}