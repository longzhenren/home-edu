package com.amur.home.admin.controller;


import com.amur.home.admin.service.HomeInfoService;
import com.amur.home.admin.service.UserFavoriteService;
import com.amur.home.admin.service.UserInfoService;
import com.amur.home.admin.service.UserLikeService;
import com.amur.home.user.entity.HomeInfo;
import com.amur.home.user.entity.UserFavorite;
import com.amur.home.user.entity.UserInfo;
import com.amur.home.user.entity.UserLike;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class HomeUserAdminController {

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private HomeInfoService homeInfoService;

    @Resource
    private UserFavoriteService userFavoriteService;

    @Resource
    private UserLikeService userLikeService;





}

