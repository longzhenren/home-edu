package com.amur.home.admin.mapper;

import com.amur.home.msg.entity.ChatUserRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatUserMapper extends BaseMapper<ChatUserRelation> {
}
