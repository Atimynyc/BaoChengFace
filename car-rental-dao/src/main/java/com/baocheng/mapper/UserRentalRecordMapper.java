package com.baocheng.mapper;

import com.baocheng.my.mapper.MyMapper;
import com.baocheng.pojo.UserRentalRecord;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserRentalRecordMapper extends MyMapper<UserRentalRecord> {

    Integer updateRentalRecordByMap(@Param("paramsMap") Map<String, Object> map);

}