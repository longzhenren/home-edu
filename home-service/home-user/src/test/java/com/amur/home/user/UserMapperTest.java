package com.amur.home.user;

import com.amur.home.common.constant.Constants;
import com.amur.home.user.entity.UserEntity;
import com.amur.home.user.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = HomeUserApplication.class)
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void getUserById() {
        userMapper.selectById(1);
    }

    @Test
    public void createUser() {
        UserEntity user = new UserEntity();
        user.setName("test");
        user.setEmail("hhh@126.com");
        user.setPassword("1016eee74007b9585bee497065daf875d0727f4d");
        user.setAge(30);
        user.setDescription("hahaha");
        user.setHomeId(2200002L);
        user.setPhone("10010");
        user.setRelativeType(Constants.UserRelativeType.MOTHER);
        user.setSex("男");
        user.setRoleId(1L);
        userMapper.insert(user);
    }
}
