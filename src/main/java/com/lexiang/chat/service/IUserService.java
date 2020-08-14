package com.lexiang.chat.service;

import com.lexiang.chat.entity.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangle
 * @since 2020-08-14
 */
public interface IUserService extends IService<User> {

    User selectUser(User user);


}
