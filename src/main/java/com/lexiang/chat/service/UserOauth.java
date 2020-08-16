package com.lexiang.chat.service;

import com.lexiang.chat.entity.User;
import com.lexiang.oauth.WLUser;
import com.lexiang.oauth.adaptor.UserInfoAdaptor;
import com.lexiang.oauth.annotation.CheckUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Component
public class UserOauth implements UserInfoAdaptor<User> {

    @Override
    public void userHandler(HttpServletRequest request, Method method, CheckUser checkUser, User loginVO) {

    }
}
