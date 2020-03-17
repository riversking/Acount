package com.rivers.user.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author riversking
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDto extends Page {

    private Integer id;

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

    private String createTime;

    private String updateTime;

    /**
     * 角色
     */
    private List<Integer> roleIds;


    private String createUser;

    private String updateUser;

    private String startDate;

    private String endDate;

    private Integer isDisable;

    private String mail;

    private String nickname;
}
