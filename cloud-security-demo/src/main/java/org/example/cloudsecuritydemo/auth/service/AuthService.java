package org.example.cloudsecuritydemo.auth.service;

import org.example.cloudsecuritydemo.auth.bo.ApiResult;

public interface AuthService {

    ApiResult login(String loginAccount, String password);

    ApiResult logout();

    ApiResult refreshToken(String token);
}
