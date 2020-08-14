package com.lexiang.chat.service.impl;

import com.lexiang.chat.entity.User;
import com.lexiang.chat.mapper.UserMapper;
import com.lexiang.chat.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangle
 * @since 2020-08-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User selectUser(User user) {
        return null;
    }
}
