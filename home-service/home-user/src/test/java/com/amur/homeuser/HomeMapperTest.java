package com.amur.homeuser;

import com.amur.homeuser.mapper.HomeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = HomeUserApplication.class)
@RunWith(SpringRunner.class)
public class HomeMapperTest {
    @Autowired
    private HomeMapper homeMapper;

    @Test
    public void getHomeById() {
        homeMapper.selectById(1);
    }
}
