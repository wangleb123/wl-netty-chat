package com.lexiang.chat.controller;

import com.google.common.collect.Maps;
import com.lexiang.chat.pojo.User;
import com.lexiang.oauth.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationCtrl{

    @Autowired
    private LoginService loginService;

    public void login(){

        loginService.login(Maps.newHashMap(),"chat",new User());

    }





}
