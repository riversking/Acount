package com.rivers.user.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author riversking
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuDto extends Page {

    private int id;
    private int parentId;
    private String icon;
    private String name;
    private String path;
    private String component;
    private String authority;
    private String redirect;
    private String code;
    private String type;
    private Integer sort;
    private String isContent;
    private String iFrame;
    private String createUser;
    private String updateUser;
}
