package com.baocheng.my.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @description: 公用mapper
 * @author: Atimynyc
 * @Date: 2021/11/6
 **/
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
