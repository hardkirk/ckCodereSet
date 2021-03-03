package com.example.demo.security;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

import java.io.Serializable;

/**
 * @Author chuke
 * @create 2020/9/12 14:11
 */
public interface SecurityContext extends Serializable {
    //获取Authentication对象
    Authentication getAuthentication();
    //放入Authentication对象
    void setAuthentication(Authentication authentication);
}
