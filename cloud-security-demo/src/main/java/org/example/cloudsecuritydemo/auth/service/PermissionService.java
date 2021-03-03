package org.example.cloudsecuritydemo.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.cloudsecuritydemo.auth.entity.PermissionInfo;
import org.example.cloudsecuritydemo.auth.bo.PermissionInfoBO;
import org.example.cloudsecuritydemo.auth.entity.PermissionInfo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 和耳朵
 * @since 2020-06-30
 */
public interface PermissionService extends IService<PermissionInfo> {

    List<PermissionInfoBO> listPermissionInfoBO();

}
