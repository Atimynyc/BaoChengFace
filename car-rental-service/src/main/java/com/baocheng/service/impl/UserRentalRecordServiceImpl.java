package com.baocheng.service.impl;

import com.baocheng.mapper.UserRentalRecordMapper;
import com.baocheng.pojo.UserRentalRecord;
import com.baocheng.service.UserRentalRecordService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: user rental car record service
 * @author: Atimynyc
 * @Date: 2021/11/7
 **/
public class UserRentalRecordServiceImpl implements UserRentalRecordService{

    @Autowired
    private UserRentalRecordMapper userRentalRecordMapper;

    @Override
    public Integer insertUserRentalRecord(UserRentalRecord userRentalRecord) {
        return userRentalRecordMapper.insert(userRentalRecord);
    }

    @Override
    public Integer updateUserRentalRecordById(UserRentalRecord userRentalRecord) {
        return userRentalRecordMapper.updateByPrimaryKey(userRentalRecord);
    }

    @Override
    public Integer updateUserRentalStatusRecordByUserIdAndCarId(String status, String userId, String carId) {
        return null;
    }

}
