package com.study.controller;

import com.study.service.Test1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author lzr
 * @date 2019/11/11 0011 17:19
 */
@RestController
public class Test1Controller {

    @Autowired
    private Test1Service test1Service;

    @GetMapping("/test1")
    public String test1(){
        return test1Service.test1();
    }

}
