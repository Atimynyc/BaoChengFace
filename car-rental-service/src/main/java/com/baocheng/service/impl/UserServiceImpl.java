package com.baocheng.service.impl;

import com.baocheng.mapper.UserMapper;
import com.baocheng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: user service
 * @author: Atimynyc
 * @Date: 2021/11/7
 **/
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

}
