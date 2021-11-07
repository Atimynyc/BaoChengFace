package com.baocheng.service;

import com.baocheng.pojo.UserRentalRecord;

public interface UserRentalRecordService {

    Integer insertUserRentalRecord(UserRentalRecord userRentalRecord);

    Integer updateUserRentalRecordById(UserRentalRecord userRentalRecord);

    Integer updateUserRentalStatusRecordByUserIdAndCarId(String status, String userId, String carId);

}
