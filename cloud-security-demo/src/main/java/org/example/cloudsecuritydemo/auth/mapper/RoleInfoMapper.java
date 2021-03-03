package org.example.cloudsecuritydemo.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.cloudsecuritydemo.auth.entity.RoleInfo;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 和耳朵
 * @since 2020-06-30
 */
public interface RoleInfoMapper extends BaseMapper<RoleInfo> {

    List<RoleInfo> listRoleByUserId(String userId);

}
