package com.amur.home.auth.service;

import com.amur.home.auth.client.UserGrpcClient;
import com.amur.home.auth.util.JwtUserDetails;
import com.amur.home.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserGrpcClient userGrpcClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userGrpcClient.getUserEntityByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        //用户权限列表，根据权限标志如@PreAuthorize("hasAuthority('sys:menu:view'))
        //标注的接口对比，决定是否可以调用该接口
        Set<String> permissions = userGrpcClient.getUserPermissionsByUserName(user.getName());
//        if (permissions == null) {
//            throw new UsernameNotFoundException("该用户权限不存在");
//        }
        List<GrantedAuthority> grantedAuthorities = permissions.stream().map(GrantedAuthorityImpl::new).collect(Collectors.toList());
        return new JwtUserDetails(user.getName(), user.getPassword(), grantedAuthorities);
    }
}
