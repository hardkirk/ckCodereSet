package org.example.cloudsecuritydemo.auth.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.cloudsecuritydemo.auth.entity.RoleInfo;
import org.example.cloudsecuritydemo.auth.mapper.RoleInfoMapper;
import org.example.cloudsecuritydemo.auth.service.RoleInfoService;
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
public class RoleInfoServiceImpl extends ServiceImpl<RoleInfoMapper, RoleInfo> implements RoleInfoService {

    @Override
    public List<RoleInfo> listRoleByUserId(String userId) {
        if (StrUtil.isEmpty(userId)) {
            return null;
        }
        return getBaseMapper().listRoleByUserId(userId);
    }
}
