package com.lexiang.chat.controller;

import com.google.common.collect.Maps;
import com.lexiang.chat.entity.User;
import com.lexiang.chat.service.IUserService;
import com.lexiang.oauth.WLUser;
import com.lexiang.oauth.annotation.CheckUser;
import com.lexiang.oauth.service.LoginService;
import com.lexiang.oauth.service.RedisService;
import com.lexiang.utils.result.ActionResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("user")
@Api(value = "ApplicationCtrl",tags = {"用户"})
public class ApplicationCtrl{

    @Resource
    private LoginService loginService;

    @Resource
    private RedisService redisService;

    @Resource
    private IUserService userService;


    @PostMapping("/login")
    public ActionResponse login(@RequestBody User user){

        String token = loginService.login(Maps.newHashMap(), user.getPhoneNumber(), user);
        HashMap<String, Object> extend = Maps.newHashMap();
        extend.put("x-token",token);
        return new ActionResponse<>(user).Extend(extend);

    }

    @GetMapping
    @CheckUser
    @ApiImplicitParams({
            @ApiImplicitParam(name = "x-token", value = "Authorization token", required = true, dataType = "string", paramType = "header")
    })
    public ActionResponse userInfo(){
        WLUser user = LoginService.getUser();
        return new ActionResponse(user);
    }





}
