package com.study.service.impl;

import com.study.service.AsyncHandleService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 异步调用
 * @author lzr
 * @date 2019/11/12 0012 16:08
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AsyncHandleServiceImpl implements AsyncHandleService {

    @Async
    @Override
    public String getDate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = format.format(new Date());
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("异步中的数据："+date);
        return date;
    }

}
