package com.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzr
 * @date 2019/11/11 0011 17:19
 */
@RestController
public class Test1 {

    @GetMapping("/test1")
    public String test1(){
        return "测试1";
    }

}
