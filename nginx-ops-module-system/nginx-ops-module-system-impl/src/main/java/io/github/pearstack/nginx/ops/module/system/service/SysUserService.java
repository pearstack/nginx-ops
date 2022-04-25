package io.github.pearstack.nginx.ops.module.system.service;

import io.github.pearstack.nginx.ops.module.system.pojo.SysUserDO;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.pearstack.nginx.ops.module.system.pojo.query.SysUserQuery;

/**
* @author lihao3
* @description 针对表【sys_user】的数据库操作Service
* @createDate 2022-04-25 15:05:15
*/
public interface SysUserService extends IService<SysUserDO> {

    void list(SysUserQuery sysUserQuery);
}
