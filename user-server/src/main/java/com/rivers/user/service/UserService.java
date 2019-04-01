package com.rivers.user.service;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.rivers.core.util.ExceptionUtil;
import com.rivers.user.api.dto.UserDto;
import com.rivers.user.api.dto.UserInfo;
import com.rivers.user.api.entity.SysMenuModel;
import com.rivers.user.api.entity.SysRoleModel;
import com.rivers.user.api.entity.SysUserModel;
import com.rivers.user.api.entity.SysUserRoleModel;
import com.rivers.user.mapper.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author riverskingking
 */
@Service
@Log4j2
public class UserService extends ServiceImpl<SysUserDao, SysUserModel> {

    @Resource
    private SysUserDao sysUserDao;

    @Resource
    private SysUserRoleDao sysUserRoleDao;

    @Resource
    private SysRoleDao sysRoleDao;

    @Resource
    private SysRoleMenuDao sysRoleMenuDao;

    @Resource
    private SysMenuDao sysMenuDao;

    private static String IS_DELETE = "is_delete";


    /**
     * 添加用户
     *
     * @param userDto userDto
     */
    @Transactional(rollbackFor = Exception.class)
    public void addUser(UserDto userDto) {
        SysUserModel sysUserModel = new SysUserModel();
        sysUserModel.setUsername(userDto.getUsername());
        sysUserModel.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
        sysUserModel.setPhone(userDto.getPhone());
        sysUserModel.setAvatar(userDto.getAvatar());
        sysUserModel.setSalt(UUID.randomUUID().toString());
        sysUserModel.setCreateUser(userDto.getCreateUser());
        sysUserModel.setUpdateUser(userDto.getUpdateUser());
        sysUserDao.insert(sysUserModel);
        userDto.getRoleIds().forEach(i -> {
            SysUserRoleModel sysUserRoleModel = new SysUserRoleModel();
            sysUserRoleModel.setRoleId(i);
            log.info("userId {}", sysUserModel.getId());
            sysUserRoleModel.setUserId(sysUserModel.getId());
            sysUserRoleDao.insert(sysUserRoleModel);
        });
    }

    /**
     * 分页查询用户
     *
     * @param userDto userDto
     * @return IPage
     */
    public IPage<SysUserModel> getUserPage(UserDto userDto) {
        QueryWrapper<SysUserModel> wrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(userDto.getUsername())) {
            wrapper.eq("username", userDto.getUsername());
        }
        if (StrUtil.isNotBlank(userDto.getPhone())) {
            wrapper.eq("phone", userDto.getPhone());
        }
        if (StrUtil.isNotBlank(userDto.getCreateTime())) {
            wrapper.ge("create_time", userDto.getCreateTime());
        }
        if (StrUtil.isNotBlank(userDto.getUpdateTime())) {
            wrapper.le("update_time", userDto.getUpdateTime());
        }
        wrapper.eq(IS_DELETE, 0);
        Page<SysUserModel> page = new Page<>(userDto.getPage(), userDto.getPageSize());
        IPage<SysUserModel> sysUserPage = sysUserDao.selectPage(page, wrapper);
        sysUserPage.getRecords().forEach(i -> {
            i.setPassword("");
            List<Integer> idList = sysUserRoleDao.selectRoleId(i.getId());
            List<SysRoleModel> roleModels = sysRoleDao.selectBatchIds(idList);
            i.setSysRoleModels(roleModels);
        });
        return sysUserPage;
    }

    /**
     * 检验用户是否正确
     *
     * @param userDto userDto
     * @return SysUserModel
     */
    public SysUserModel getUserDetail(UserDto userDto) {
        QueryWrapper<SysUserModel> wrapper = new QueryWrapper<>();
        wrapper.eq(IS_DELETE, 0);
        wrapper.eq("username", userDto.getUsername());
        SysUserModel user = sysUserDao.selectOne(wrapper);
        if (null == user) {
            return new SysUserModel();
        }
        if (new BCryptPasswordEncoder().matches(userDto.getPassword(), user.getPassword())) {
            log.info("is Right {}", userDto.getPassword());
            return user;
        }
        return new SysUserModel();
    }

    /**
     * 根据id查询用户详情
     *
     * @param id id
     * @return SysUserModel
     */
    public SysUserModel getUserById(Integer id) {
        QueryWrapper<SysUserModel> wrapper = new QueryWrapper<>();
        wrapper.eq(IS_DELETE, 0);
        wrapper.eq("id", id);
        SysUserModel user = sysUserDao.selectOne(wrapper);
        List<Integer> idList = sysUserRoleDao.selectRoleId(id);
        user.setRoleIds(idList);
        return user;
    }

    /**
     * 获取用户
     *
     * @param user user
     * @return List
     */
    public List<SysUserModel> getUser(UserDto user) {
        QueryWrapper<SysUserModel> wrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(user.getUsername()) || StrUtil.isNotBlank(user.getPhone())) {
            wrapper.eq("username", user.getUsername()).or().eq("phone", user.getPhone());
        }
        wrapper.eq(IS_DELETE, 0);
        return sysUserDao.selectList(wrapper);
    }

    /**
     * 通过用户名查询用户信息
     *
     * @param username username
     * @return List
     */
    public SysUserModel getUserInfo(String username) {
        QueryWrapper<SysUserModel> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.eq(IS_DELETE, 0);
        return sysUserDao.selectOne(wrapper);
    }

    public UserInfo queryUserInfo(String username) {
        UserInfo userInfo = new UserInfo();
        QueryWrapper<SysUserModel> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.eq(IS_DELETE, 0);
        SysUserModel sysUserModel = sysUserDao.selectOne(wrapper);
        Integer userId = sysUserModel.getId();
        List<Integer> roleIds = sysUserRoleDao.selectRoleId(userId);
        Set<String> permission = Sets.newHashSet();
        roleIds.forEach(roleId -> {
            List<String> permissionList = sysMenuDao.getMenuByRoleId(roleId)
                    .stream()
                    .filter(i -> StrUtil.isNotBlank(i.getPermission()))
                    .map(SysMenuModel::getPermission)
                    .collect(Collectors.toList());
            permission.addAll(permissionList);
        });
        userInfo.setSysUser(sysUserModel);
        userInfo.setPermissions(Lists.newArrayList(permission));
        userInfo.setRoles(roleIds);
        return userInfo;
    }

    /**
     * 通过id删除用户
     *
     * @param id
     */
    public void deleteById(Integer id) {
        try {
            sysUserDao.deleteById(id);
        } catch (Exception e) {
            ExceptionUtil.throwBusinessException("101005", "删除失败");
        }
    }
}
