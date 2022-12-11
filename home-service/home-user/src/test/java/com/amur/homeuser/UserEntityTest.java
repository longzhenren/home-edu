package com.amur.homeuser;

import com.amur.homeuser.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserEntityTest {
    @Autowired(required=false)
    private UserMapper userMapper;

    @Test
    public void getUserById() {
        userMapper.selectById(1);
    }
}
