package org.example.cloudsecuritydemo.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.cloudsecuritydemo.auth.entity.RoleInfo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 和耳朵
 * @since 2020-06-30
 */
public interface RoleInfoService extends IService<RoleInfo> {

    List<RoleInfo> listRoleByUserId(String userId);

}
