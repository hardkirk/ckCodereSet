package org.example.cloudsecuritydemo.auth.component;


import org.example.cloudsecuritydemo.auth.bo.PermissionInfoBO;
import org.example.cloudsecuritydemo.auth.cache.Cache;
import org.example.cloudsecuritydemo.auth.constant.CacheName;
import org.example.cloudsecuritydemo.auth.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class InitProcessor {
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private Cache caffeineCache;

    @PostConstruct
    public void init() {
        List<PermissionInfoBO> permissionInfoList = permissionService.listPermissionInfoBO();
        permissionInfoList.forEach(permissionInfo -> {
            caffeineCache.put(CacheName.PERMISSION, permissionInfo.getPermissionUri() + ":" + permissionInfo.getPermissionMethod(), permissionInfo);
        });
    }
}
