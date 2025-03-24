package com.yezhiyuan.service;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ServiceB {
    @Resource
    ServiceA serviceA;
}
