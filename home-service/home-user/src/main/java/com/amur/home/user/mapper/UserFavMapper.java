package com.amur.home.user.mapper;

import com.amur.home.user.entity.UserFavorite;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserFavMapper extends BaseMapper<UserFavorite> {
}
