package org.example.cloudsecuritydemo.auth.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.cloudsecuritydemo.auth.bo.PermissionInfoBO;
import org.example.cloudsecuritydemo.auth.entity.PermissionInfo;
import org.example.cloudsecuritydemo.auth.mapper.PermissionMapper;
import org.example.cloudsecuritydemo.auth.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 和耳朵
 * @since 2020-06-30
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, PermissionInfo> implements PermissionService {


    @Override
    public List<PermissionInfoBO> listPermissionInfoBO() {
        return getBaseMapper().listPermissionInfoBO();
    }
}
