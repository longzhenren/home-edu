package com.amur.home.user.service.impl;

import com.amur.home.user.HomeUserApplication;
import com.amur.home.user.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = HomeUserApplication.class)
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;

//    private final UserEntity userEntity = buildEntity();

    @Test
    public void getUserInfo() {
        System.out.println(userService.getUserInfo(1L));
    }

    @Test
    public void updateUser() {
        System.out.println(userService.updateUser(buildEntity()));
    }

    @Test
    public void deleteUser() {
        System.out.println(userService.deleteUser(1L));
    }

    @Test
    public void createUser() {
        System.out.println(userService.createUser(buildEntity()));
    }

    private UserEntity buildEntity() {
        UserEntity userEntity = new UserEntity();
//        userEntity.setId(1L);
        userEntity.setName("test");
        userEntity.setAge(18);
        userEntity.setSex("男");
        return userEntity;
    }
}