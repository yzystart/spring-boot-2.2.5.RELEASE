package com.yezhiyuan.service;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ServiceA {
    public ServiceA(){
        System.out.println("A创建完成");
    }
    @Resource
    ServiceB serviceB;
}
