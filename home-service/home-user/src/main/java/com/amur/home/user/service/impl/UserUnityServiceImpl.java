package com.amur.home.user.service.impl;

import com.amur.home.user.entity.UserUnity;
import com.amur.home.user.mapper.UserUnityMapper;
import com.amur.home.user.service.UserUnityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserUnityServiceImpl extends ServiceImpl<UserUnityMapper, UserUnity> implements UserUnityService {
}
