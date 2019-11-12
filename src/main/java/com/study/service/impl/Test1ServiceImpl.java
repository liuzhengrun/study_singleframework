package com.study.service.impl;

import com.study.service.AsyncHandleService;
import com.study.service.Test1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lzr
 * @date 2019/11/12 0012 16:05
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class Test1ServiceImpl implements Test1Service {

    @Autowired
    private AsyncHandleService asyncHandleService;

    @Override
    public String test1() {
        String date = asyncHandleService.getDate();
        System.out.println("获取时间:"+date);// 异步date会是null
        System.out.println("得到数据");
        return "得到数据";
    }
}
