package com.amur.home.user.service.impl;

import com.amur.home.user.entity.UserInfo;
import com.amur.home.user.mapper.UserInfoMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@DisplayName("UserServiceImpl 测试类")
class UserServiceImplTest {

    private UserServiceImpl userService;

    @Mock
    private UserInfoMapper userInfoMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl();
        userService.setUserInfoMapper(userInfoMapper);
    }

    @Test
    @DisplayName("根据用户 ID 获取用户信息")
    void testGetUserInfo() {
        Long userId = 1L;
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userId);
        Mockito.when(userInfoMapper.selectById(userId)).thenReturn(userInfo);
        UserInfo result = userService.getUserInfo(userId).getData();
        Assertions.assertEquals(userInfo, result);
    }

    @Test
    @DisplayName("更新用户信息")
    void testUpdateUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1L);
        Mockito.when(userInfoMapper.updateById(userInfo)).thenReturn(1);
        boolean result = userService.updateUser(userInfo).isSuccess();
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("删除用户")
    void testDeleteUser() {
        Long userId = 1L;
        Mockito.when(userInfoMapper.deleteById(userId)).thenReturn(1);
        boolean result = userService.deleteUser(userId).isSuccess();
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("创建用户")
    void testCreateUser() {
        UserInfo userInfo = new UserInfo();
        Mockito.when(userInfoMapper.insert(userInfo)).thenReturn(1);
        Long result = userService.createUser("testUserName").getData();
        Assertions.assertEquals(userInfo.getId(), result);
    }

    @Test
    @DisplayName("根据用户名获取用户信息")
    void testGetUserByName() {
        String username = "test";
        UserInfo userInfo = new UserInfo();
        userInfo.setName(username);
        Mockito.when(userInfoMapper.selectOne(ArgumentMatchers.any())).thenReturn(userInfo);
        UserInfo result = userService.getUserByName(username).getData();
        Assertions.assertEquals(userInfo, result);
    }
}
