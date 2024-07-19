package com.yezhiyuan.controller;


import com.yezhiyuan.anno.SkipCheckToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    public static ThreadLocal<String>t =new ThreadLocal<>();


    @SkipCheckToken
    @RequestMapping("test")
    public String test(){
        System.out.println("test");
        System.out.println("当前线程"+Thread.currentThread().getName());
        String s = t.get();
        t.set("Thread.currentThread().getName()");
        return s;
    }

    @RequestMapping("err")
    public String err() throws Exception {
        t.set("Thread.currentThread().getName()");
        throw new Exception();
    }
}
