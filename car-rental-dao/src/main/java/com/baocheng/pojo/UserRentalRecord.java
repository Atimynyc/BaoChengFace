package com.baocheng.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "user_rental_record")
public class UserRentalRecord {
    @Id
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "car_id")
    private String carId;

    @Column(name = "rental_status")
    private String rentalStatus;

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
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return car_id
     */
    public String getCarId() {
        return carId;
    }

    /**
     * @param carId
     */
    public void setCarId(String carId) {
        this.carId = carId;
    }

    /**
     * @return rental_status
     */
    public String getRentalStatus() {
        return rentalStatus;
    }

    /**
     * @param rentalStatus
     */
    public void setRentalStatus(String rentalStatus) {
        this.rentalStatus = rentalStatus;
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