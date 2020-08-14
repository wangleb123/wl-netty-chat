package com.lexiang.chat.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import com.lexiang.oauth.WLUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangle
 * @since 2020-08-14
 */
@Data
@Accessors(chain = true)
public class User extends Model<User> implements WLUser {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 创建时间
     */
    @TableField("create_date")
    private Date createDate;
    /**
     * 用户性别
     */
    @TableField("gender")
    private Integer gender;
    /**
     * 用户头像
     */
    @TableField("avatar_url")
    private String avatarUrl;
    /**
     * 修改时间
     */
    @TableField("modify_date")
    private Date modifyDate;
    /**
     * 用户昵称
     */
    @TableField("user_name")
    private String userName;
    /**
     * 用户密码
     */
    @TableField("pass_word")
    private String passWord;
    /**
     * 用户手机号
     */
    @TableField("phone_number")
    private String phoneNumber;
    /**
     * 删除标志位
     */
    @TableField("state")
    private Integer state;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
