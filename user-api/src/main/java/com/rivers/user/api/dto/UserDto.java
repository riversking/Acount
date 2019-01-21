package com.rivers.user.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author rivers
 */
//@EqualsAndHashCode(callSuper = true)
@Data
public class UserDto {

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 角色
     */
    private List<Integer> roleIds;

    private String createUser;

    private String updateUser;
}
