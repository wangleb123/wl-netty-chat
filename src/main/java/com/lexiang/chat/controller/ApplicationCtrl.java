package com.lexiang.chat.controller;

import com.google.common.collect.Maps;
import com.lexiang.chat.entity.User;
import com.lexiang.chat.service.IUserService;
import com.lexiang.oauth.service.LoginService;
import com.lexiang.oauth.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class ApplicationCtrl{

    @Resource
    private LoginService loginService;

    @Resource
    private RedisService redisService;

    @Resource
    private IUserService userService;




    @RequestMapping("/login")
    public void login(@RequestBody User user){

        User users = userService.selectUser(user);
        String login = loginService.login(Maps.newHashMap(), user.getId().toString(), users);



    }





}
