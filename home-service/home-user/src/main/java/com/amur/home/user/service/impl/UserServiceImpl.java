package com.amur.home.user.service.impl;

import com.amur.home.user.entity.UserInfo;
import com.amur.home.user.mapper.UserMapper;
import com.amur.home.user.service.UserService;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    @Setter
    private UserMapper userMapper;

    /**
     * 根据用户 ID 获取用户信息。
     *
     * @param userId 用户 ID。
     * @return 用户实体对象。
     */
    @Override
    public ServiceResult<UserInfo> getUserInfo(Long userId) {
        UserInfo userInfo = userMapper.selectById(userId);
        if (userInfo == null) {
            return ServiceResult.fail("用户不存在");
        } else {
            return ServiceResult.success(userInfo);
        }
    }

    /**
     * 更新用户信息。
     *
     * @param userInfo 用户实体对象。
     * @return 如果更新成功，返回 true；否则，返回 false。
     */
    @Override
    public ServiceResult<Void> updateUser(UserInfo userInfo) {
        ServiceResult<Void> result = new ServiceResult<>();
        if (userMapper.updateById(userInfo) > 0) {
            result.setSuccess(true);
        } else {
            result.setMessage("更新用户信息失败！");
        }
        return result;
    }

    /**
     * 删除用户。
     *
     * @param userId 用户 ID。
     * @return 如果删除成功，返回 true；否则，返回 false。
     */
    @Override
    public ServiceResult<Void> deleteUser(Long userId) {
        ServiceResult<Void> result = new ServiceResult<>();
        if (userMapper.deleteById(userId) > 0) {
            result.setSuccess(true);
        } else {
            result.setMessage("删除用户失败！");
        }
        return result;
    }

    /**
     * 创建用户。
     *
     * @param userInfo 用户实体对象。
     * @return 新创建的用户的 ID。
     */
    @Override
    public ServiceResult<Long> createUser(UserInfo userInfo) {
        int res = userMapper.insert(userInfo);
        if (res <= 0) {
            return ServiceResult.fail("创建用户失败");
        } else {
            return ServiceResult.success(userInfo.getId());
        }
    }

    /**
     * 根据用户名获取用户信息。
     *
     * @param username 用户名。
     * @return 用户实体对象。
     */
    @Override
    public ServiceResult<UserInfo> getUserByName(String username) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", username);
        UserInfo userInfo = userMapper.selectOne(queryWrapper);
        if (userInfo == null) {
            return ServiceResult.fail("用户不存在");
        } else {
            return ServiceResult.success(userInfo);
        }
    }
}
