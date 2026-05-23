package com.amur.home.user.service.impl;

import com.amur.home.user.client.TinyIdGrpcClient;
import com.amur.home.user.entity.UserInfo;
import com.amur.home.user.entity.UserFavorite;
import com.amur.home.user.entity.UserLike;
import com.amur.home.user.entity.UserUnity;
import com.amur.home.user.mapper.UserFavMapper;
import com.amur.home.user.mapper.UserInfoMapper;
import com.amur.home.user.mapper.UserLikeMapper;
import com.amur.home.user.mapper.UserUnityMapper;
import com.amur.home.user.util.RedisUtils;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;

@DisplayName("UserServiceImpl 测试类")
class UserServiceImplTest {

    private UserServiceImpl userService;

    @Mock
    private UserInfoMapper userInfoMapper;

    @Mock
    private UserFavMapper userFavMapper;

    @Mock
    private UserLikeMapper userLikeMapper;

    @Mock
    private UserUnityMapper userUnityMapper;

    @Mock
    private TinyIdGrpcClient tinyIdGrpcClient;

    @Mock
    private RedisUtils redisUtils;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl();
        userService.setUserInfoMapper(userInfoMapper);
        setField(userService, "userFavMapper", userFavMapper);
        setField(userService, "userLikeMapper", userLikeMapper);
        setField(userService, "userUnityMapper", userUnityMapper);
        setField(userService, "tinyIdGrpcClient", tinyIdGrpcClient);
        setField(userService, "redisUtils", redisUtils);
    }

    private void setField(Object target, String fieldName, Object value) {
        try {
            java.lang.reflect.Field f = target.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            f.set(target, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("根据用户 ID 获取用户信息")
    void testGetUserInfo() {
        Long userId = 1L;
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userId);
        userInfo.setName("test");
        Mockito.when(redisUtils.exists(anyString())).thenReturn(false);
        Mockito.when(userInfoMapper.selectById(userId)).thenReturn(userInfo);
        ServiceResult<UserInfo> result = userService.getUserInfo(userId);
        Assertions.assertTrue(result.isSuccess());
        Assertions.assertEquals(userInfo, result.getData());
    }

    @Test
    @DisplayName("获取用户信息-用户不存在应抛出异常")
    void testGetUserInfoNotFound() {
        Long userId = 999L;
        Mockito.when(redisUtils.exists(anyString())).thenReturn(false);
        Mockito.when(userInfoMapper.selectById(userId)).thenReturn(null);
        Assertions.assertThrows(RuntimeException.class, () -> userService.getUserInfo(userId));
    }

    @Test
    @DisplayName("更新用户信息")
    void testUpdateUser() {
        Long userId = 1L;
        UserInfo existingUser = new UserInfo();
        existingUser.setId(userId);
        existingUser.setName("old");
        Mockito.when(userInfoMapper.selectById(userId)).thenReturn(existingUser);
        Mockito.when(userInfoMapper.updateById(ArgumentMatchers.any(UserInfo.class))).thenReturn(1);
        Mockito.when(redisUtils.set(anyString(), ArgumentMatchers.any())).thenReturn(true);
        ServiceResult<Void> result = userService.updateUser(userId, "new desc", "13800000000", "test@test.com", null, null, null, null);
        Assertions.assertTrue(result.isSuccess());
    }

    @Test
    @DisplayName("删除用户")
    void testDeleteUser() {
        Long userId = 1L;
        Mockito.when(userInfoMapper.deleteById(userId)).thenReturn(1);
        Mockito.when(userFavMapper.deleteById(userId)).thenReturn(1);
        Mockito.doNothing().when(redisUtils).remove(anyString());
        ServiceResult<Void> result = userService.deleteUser(userId);
        Assertions.assertTrue(result.isSuccess());
    }

    @Test
    @DisplayName("创建用户")
    void testCreateUser() {
        Long newId = 100L;
        Mockito.when(tinyIdGrpcClient.getNextId(anyString())).thenReturn(ServiceResult.success(newId));
        Mockito.when(userInfoMapper.insert(ArgumentMatchers.any(UserInfo.class))).thenReturn(1);
        Mockito.when(userFavMapper.insert(ArgumentMatchers.any(UserFavorite.class))).thenReturn(1);
        Mockito.when(userLikeMapper.insert(ArgumentMatchers.any(UserLike.class))).thenReturn(1);
        Mockito.when(userUnityMapper.insert(ArgumentMatchers.any(UserUnity.class))).thenReturn(1);
        Mockito.when(redisUtils.set(anyString(), ArgumentMatchers.any())).thenReturn(true);
        ServiceResult<Long> result = userService.createUser("testUserName");
        Assertions.assertTrue(result.isSuccess());
        Assertions.assertEquals(newId, result.getData());
    }

    @Test
    @DisplayName("根据用户名获取用户信息")
    void testGetUserByName() {
        String username = "test";
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1L);
        userInfo.setName(username);
        Mockito.when(userInfoMapper.selectOne(ArgumentMatchers.any(QueryWrapper.class))).thenReturn(userInfo);
        ServiceResult<UserInfo> result = userService.getUserByName(username);
        Assertions.assertTrue(result.isSuccess());
        Assertions.assertEquals(userInfo, result.getData());
    }

    @Test
    @DisplayName("根据用户名获取用户信息-不存在应抛出异常")
    void testGetUserByNameNotFound() {
        String username = "nonexistent";
        Mockito.when(userInfoMapper.selectOne(ArgumentMatchers.any(QueryWrapper.class))).thenReturn(null);
        Assertions.assertThrows(RuntimeException.class, () -> userService.getUserByName(username));
    }

    @Test
    @DisplayName("检查用户是否存在")
    void testCheckUserExists() {
        Long userId = 1L;
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userId);
        Mockito.when(userInfoMapper.selectById(userId)).thenReturn(userInfo);
        ServiceResult<Boolean> result = userService.checkUserExists(userId);
        Assertions.assertTrue(result.isSuccess());
        Assertions.assertTrue(result.getData());
    }
}
