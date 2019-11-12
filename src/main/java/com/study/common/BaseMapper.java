package com.study.common;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author lzr
 * @date 2019/11/11 0026 09:38
 */
@RegisterMapper
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T>, ExampleMapper<T> {
}
