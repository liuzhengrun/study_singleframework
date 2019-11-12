package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author lzr
 * @date 2019/11/11 0011 17:18
 */
@MapperScan("com.study.dao")// 扫描mapper接口文件，注意引入的包是：“tk.mybatis.spring.annotation.MapperScan”
@EnableScheduling// 开启定时器线程
@EnableAsync// 开启异步操作
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

}
