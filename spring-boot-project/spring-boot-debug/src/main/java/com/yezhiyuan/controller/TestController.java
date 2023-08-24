package com.yezhiyuan.controller;


import com.yezhiyuan.anno.SkipCheckToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {



    @SkipCheckToken
    @RequestMapping("test")
    public String test(){
        System.out.println("test");
        return "success";
    }
}
