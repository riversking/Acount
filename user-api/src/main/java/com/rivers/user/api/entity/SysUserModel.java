package com.rivers.user.api.entity;



import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * SysUser
 *
 * @author riversking
 * @Date 2018-12-14 10:42
 */
@TableName("sys_user")
public class SysUserModel extends Model<SysUserModel> {
	private static final long serialVersionUID = 1L;
	/**
	 * 头像
	 *
	 */
	@TableField(value="avatar")
	private String avatar;

	/**
	 * 创建时间
	 *
	 */
	@TableField(value="create_time")
	private Date createTime;

	/**
	 * 0-正常，1-删除
	 *
	 */
	@TableField(value="del_flag")
	private String delFlag;

	/**
	 * 部门ID
	 *
	 */
	@TableField(value="dept_id")
	private Integer deptId;

	/**
	 * Password
	 *
	 */
	@TableField(value="password")
	private String password;

	/**
	 * 简介
	 *
	 */
	@TableField(value="phone")
	private String phone;

	/**
	 * 随机盐
	 *
	 */
	@TableField(value="salt")
	private String salt;

	/**
	 * 修改时间
	 *
	 */
	@TableField(value="update_time")
	private Date updateTime;

	/**
	 * 主键ID
	 *
	 */
	@TableField(value="id")
	private Integer id;

	/**
	 * 用户名
	 *
	 */
	@TableField(value="username")
	private String username;


	/**
	 * 获取: 头像
	 *
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * 设置: 头像
	 *
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * 获取: 创建时间
	 *
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置: 创建时间
	 *
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取: 0-正常，1-删除
	 *
	 */
	public String getDelFlag() {
		return delFlag;
	}
	/**
	 * 设置: 0-正常，1-删除
	 *
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取: 部门ID
	 *
	 */
	public Integer getDeptId() {
		return deptId;
	}
	/**
	 * 设置: 部门ID
	 *
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取: Password
	 *
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置: Password
	 *
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取: 简介
	 *
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置: 简介
	 *
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取: 随机盐
	 *
	 */
	public String getSalt() {
		return salt;
	}
	/**
	 * 设置: 随机盐
	 *
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/**
	 * 获取: 修改时间
	 *
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置: 修改时间
	 *
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取: 主键ID
	 *
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置: 主键ID
	 *
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取: 用户名
	 *
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置: 用户名
	 *
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}