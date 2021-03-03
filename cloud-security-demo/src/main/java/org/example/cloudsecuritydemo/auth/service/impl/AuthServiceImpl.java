package org.example.cloudsecuritydemo.auth.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.cloudsecuritydemo.auth.bo.AccessToken;
import org.example.cloudsecuritydemo.auth.bo.ApiResult;
import org.example.cloudsecuritydemo.auth.cache.Cache;
import org.example.cloudsecuritydemo.auth.constant.CacheName;
import org.example.cloudsecuritydemo.auth.entity.UserDetail;
import org.example.cloudsecuritydemo.auth.provider.AuthProvider;
import org.example.cloudsecuritydemo.auth.provider.JwtProvider;
import org.example.cloudsecuritydemo.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private Cache caffeineCache;


    @Override
    public ApiResult login(String loginAccount, String password) {

        log.debug("进入login方法");
        // 1 创建UsernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken usernameAuthentication = new UsernamePasswordAuthenticationToken(loginAccount, password);
        // 2 认证
        Authentication authentication = this.authenticationManager.authenticate(usernameAuthentication);
        // 3 保存认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 4 生成自定义token
        AccessToken accessToken = jwtProvider.createToken((UserDetails) authentication.getPrincipal());

        UserDetail userDetail = (UserDetail) authentication.getPrincipal();
        // 放入缓存
        caffeineCache.put(CacheName.USER, userDetail.getUsername(), userDetail);
        return ApiResult.ok(accessToken);
    }

    @Override
    public ApiResult logout() {
        caffeineCache.remove(CacheName.USER, AuthProvider.getLoginAccount());
        SecurityContextHolder.clearContext();
        return ApiResult.ok();
    }

    @Override
    public ApiResult refreshToken(String token) {
        AccessToken accessToken = jwtProvider.refreshToken(token);
        UserDetail userDetail = caffeineCache.get(CacheName.USER, accessToken.getLoginAccount(), UserDetail.class);
        caffeineCache.put(CacheName.USER, accessToken.getLoginAccount(), userDetail);
        return ApiResult.ok(accessToken);
    }
}
