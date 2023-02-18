package com.amur.home.user;

import com.amur.home.user.config.MyBatisTinyIdGenerator;
import com.amur.home.user.entity.HomeEntity;
import com.amur.home.user.mapper.HomeMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest(classes = HomeUserApplication.class)
@RunWith(SpringRunner.class)
public class HomeMapperTest {
    @Autowired(required = false)
    private HomeMapper homeMapper;

    @Autowired
    @InjectMocks
    private MyBatisTinyIdGenerator myBatisTinyIdGenerator;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(myBatisTinyIdGenerator, "bizType", "home");
        ReflectionTestUtils.setField(myBatisTinyIdGenerator, "token", "0f673adf80504e2eaa552f5d791b644c");
    }

    @Test
    public void getHomeById() {
        homeMapper.selectById(1);
    }

    @Test
    public void getHomeList() {
        System.out.println(homeMapper.selectList(null));
    }

    @Test
    public void createHome() {
        for (int i = 0; i < 10000; i++) {
            HomeEntity homeEntity = new HomeEntity();
            homeEntity.setName("test");
            homeEntity.setDescription("test");
            homeEntity.setAvatarUrl("test");
            homeEntity.setAdminId(1L);
            homeMapper.insert(homeEntity);
            System.out.println(homeEntity.getId());
        }
//        homeMapper.insert(homeEntity);
    }

    @Test
    public void test() {
        MyBatisTinyIdGenerator myBatisTinyIdGenerator = new MyBatisTinyIdGenerator();
        System.out.println(myBatisTinyIdGenerator.nextId(null));
    }

    @Test
    public void deleteHome() {
        homeMapper.deleteById(1);
    }

    @Test
    public void updateHome() {
        HomeEntity homeEntity = homeMapper.selectById(1);
        homeEntity.setName("test");
        homeEntity.setDescription("test");
        homeEntity.setAvatarUrl("test1");
        homeEntity.setAdminId(1L);
        homeMapper.updateById(homeEntity);
    }
}
