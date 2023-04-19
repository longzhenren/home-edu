package com.amur.home.user.controller;

import com.amur.home.user.entity.HomeInfo;
import com.amur.home.user.entity.UserFavorite;
import com.amur.home.user.entity.UserInfo;
import com.amur.home.user.entity.UserLike;
import com.amur.home.user.service.HomeInfoService;
import com.amur.home.user.service.UserFavoriteService;
import com.amur.home.user.service.UserInfoService;
import com.amur.home.user.service.UserLikeService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private UserLikeService userLikeService;
    @Resource
    private UserFavoriteService userFavoriteService;
    @Resource
    private HomeInfoService homeInfoService;

    @GetMapping("/home/{id}")
    public HomeInfo getHomeInfoById(@PathVariable("id") Long id) {
        return homeInfoService.getById(id);
    }

    @GetMapping("/home/")
    public List<HomeInfo> getAllHomeInfo() {
        return homeInfoService.list();
    }

    @GetMapping("/home/page")
    public IPage<HomeInfo> getHomeInfoByPage(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<HomeInfo> page = new Page<>(pageNo, pageSize);
        return homeInfoService.page(page, null);
    }

    @PostMapping("/home/")
    public HomeInfo addHomeInfo(@RequestBody HomeInfo homeInfo) {
        homeInfoService.save(homeInfo);
        return homeInfo;
    }

    @PutMapping("/home/{id}")
    public HomeInfo updateHomeInfo(@PathVariable("id") Long id, @RequestBody HomeInfo homeInfo) {
        homeInfo.setId(id);
        homeInfoService.updateById(homeInfo);
        return homeInfo;
    }

    @DeleteMapping("/home/{id}")
    public void deleteHomeInfo(@PathVariable("id") Long id) {
        homeInfoService.removeById(id);
    }

    @PostMapping("/home/query")
    public IPage<HomeInfo> queryHomeInfo(@RequestParam Map<String, Object> params) {
        Map<String, Map<String, Object>> param = (Map<String, Map<String, Object>>) params.get("params");
        String sortField = params.get("sortField").toString();
        String sortOrder = params.get("sortOrder").toString();
        Integer pageNo = Integer.parseInt(params.get("pageNo").toString());
        Integer pageSize = Integer.parseInt(params.get("pageSize").toString());
        return homeInfoService.queryHomeInfo(param, sortField, sortOrder, pageNo, pageSize).getData();
    }

    @GetMapping("/user/{id}")
    public UserInfo getUserInfoById(@PathVariable("id") Long id) {
        return userInfoService.getById(id);
    }

    @GetMapping("/user/")
    public List<UserInfo> getAllUserInfo() {
        return userInfoService.list();
    }

    @GetMapping("/user/page")
    public IPage<UserInfo> getUserInfoByPage(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<UserInfo> page = new Page<>(pageNo, pageSize);
        return userInfoService.page(page, null);
    }

    @PostMapping("/user/")
    public UserInfo addUserInfo(@RequestBody UserInfo userInfo) {
        userInfoService.save(userInfo);
        return userInfo;
    }

    @PutMapping("/user/{id}")
    public UserInfo updateUserInfo(@PathVariable("id") Long id, @RequestBody UserInfo userInfo) {
        userInfo.setId(id);
        userInfoService.updateById(userInfo);
        return userInfo;
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserInfo(@PathVariable("id") Long id) {
        userInfoService.removeById(id);
    }

    @PostMapping("/user/query")
    public IPage<UserInfo> queryUserInfo(@RequestParam Map<String, Object> params) {
        Map<String, Map<String, Object>> param = (Map<String, Map<String, Object>>) params.get("params");
        String sortField = params.get("sortField").toString();
        String sortOrder = params.get("sortOrder").toString();
        Integer pageNo = Integer.parseInt(params.get("pageNo").toString());
        Integer pageSize = Integer.parseInt(params.get("pageSize").toString());
        return userInfoService.queryUserInfo(param, sortField, sortOrder, pageNo, pageSize).getData();
    }

    @GetMapping("/fav/{id}")
    public UserFavorite getUserFavorite(@PathVariable("id") Long id) {
        return userFavoriteService.getById(id);
    }

    @PostMapping("/fav/")
    public UserFavorite createUserFavorite(@RequestBody UserFavorite userFavorite) {
        userFavoriteService.save(userFavorite);
        return userFavorite;
    }

    @PutMapping("/fav/")
    public UserFavorite updateUserFavorite(@RequestBody UserFavorite userFavorite) {
        userFavoriteService.updateById(userFavorite);
        return userFavorite;
    }

    @DeleteMapping("/fav/{id}")
    public void deleteUserFavorite(@PathVariable("id") Long id) {
        userFavoriteService.removeById(id);
    }

    @GetMapping("/fav/")
    public List<UserFavorite> getAllUserFavorites() {
        return userFavoriteService.list();
    }

    @PostMapping("/fav/query")
    public IPage<UserFavorite> queryUserFavorite(@RequestParam Map<String, Object> params) {
        Map<String, Map<String, Object>> param = (Map<String, Map<String, Object>>) params.get("params");
        String sortField = params.get("sortField").toString();
        String sortOrder = params.get("sortOrder").toString();
        Integer pageNo = Integer.parseInt(params.get("pageNo").toString());
        Integer pageSize = Integer.parseInt(params.get("pageSize").toString());
        return userFavoriteService.queryUserFavorite(param, sortField, sortOrder, pageNo, pageSize).getData();
    }


    @GetMapping("/like/{id}")
    public UserLike getUserLike(@PathVariable("id") Long id) {
        return userLikeService.getById(id);
    }

    @PostMapping("/like/")
    public UserLike createUserLike(@RequestBody UserLike userLike) {
        userLikeService.save(userLike);
        return userLike;
    }

    @PutMapping("/like/")
    public UserLike updateUserLike(@RequestBody UserLike userLike) {
        userLikeService.updateById(userLike);
        return userLike;
    }

    @DeleteMapping("/like/{id}")
    public void deleteUserLike(@PathVariable("id") Long id) {
        userLikeService.removeById(id);
    }

    @GetMapping("/like/")
    public List<UserLike> getAllUserLikes() {
        return userLikeService.list();
    }

    @PostMapping("/like/query")
    public IPage<UserLike> queryUserLike(@RequestParam Map<String, Object> params) {
        Map<String, Map<String, Object>> param = (Map<String, Map<String, Object>>) params.get("params");
        String sortField = params.get("sortField").toString();
        String sortOrder = params.get("sortOrder").toString();
        Integer pageNo = Integer.parseInt(params.get("pageNo").toString());
        Integer pageSize = Integer.parseInt(params.get("pageSize").toString());
        return userLikeService.queryUserLike(param, sortField, sortOrder, pageNo, pageSize).getData();
    }
}
