package org.example.cloudsecuritydemo.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.example.cloudsecuritydemo.auth.entity.UserInfo;

import org.example.cloudsecuritydemo.auth.service.UserService;
import org.springframework.stereotype.Service;
import org.example.cloudsecuritydemo.auth.mapper.UserMapper;

/**
 * <p>
 * User服务实现类
 * </p>
 *
 * @author 和耳朵
 * @since 2020-06-30
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements UserService {

}
