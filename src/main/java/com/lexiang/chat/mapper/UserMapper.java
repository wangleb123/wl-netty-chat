package com.lexiang.chat.mapper;

import com.lexiang.chat.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangle
 * @since 2020-08-14
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User selectUser();

}
