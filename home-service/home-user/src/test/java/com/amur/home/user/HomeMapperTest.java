package com.amur.home.user;

import com.amur.home.user.entity.HomeEntity;
import com.amur.home.user.mapper.HomeMapper;
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

    @Test
    public void getHomeList() {
        System.out.println(homeMapper.selectList(null));
    }

    @Test
    public void createHome() {
        HomeEntity homeEntity = new HomeEntity();
        homeEntity.setId(1L);
        homeEntity.setName("test");
        homeEntity.setAddress("test");
        homeEntity.setDescription("test");
        homeEntity.setAvatarUrl("test");
        homeEntity.setImageUrls("test");
        homeEntity.setAdminId(1L);
        homeEntity.setHomeUserIds("test");
        homeMapper.insert(homeEntity);
    }

    @Test
    public void deleteHome() {
        homeMapper.deleteById(1);
    }
    @Test
    public void updateHome() {
        HomeEntity homeEntity = homeMapper.selectById(1);
        homeEntity.setId(1L);
        homeEntity.setName("test");
        homeEntity.setAddress("test");
        homeEntity.setDescription("test");
        homeEntity.setAvatarUrl("test1");
        homeEntity.setImageUrls("test");
        homeEntity.setAdminId(1L);
        homeEntity.setHomeUserIds("test");
        homeMapper.updateById(homeEntity);
    }
}
