package com.lexiang.chat.controller;

import com.google.common.collect.Maps;
import com.lexiang.chat.pojo.User;
import com.lexiang.oauth.service.LoginService;
import com.lexiang.oauth.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class ApplicationCtrl{

    @Autowired
    private LoginService loginService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/login")
    public void login(){

        int a = 1;
        redisService.set("dasd","da");
        loginService.login(Maps.newHashMap(),"chat",new User());

    }





}
