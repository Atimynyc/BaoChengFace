package com.baocheng.service;

import com.baocheng.pojo.UserRentalRecord;

public interface UserRentalRecordService {

    Integer insertUserRentalRecord(UserRentalRecord userRentalRecord);

    Integer updateUserRentalRecordById(UserRentalRecord userRentalRecord);

    Integer updateUserRentalStatusRecordByRecordId(String status, String recordId);

    UserRentalRecord selectRecordByUserIdCarIdAndStatus(String userId, String carId, String status);

}
