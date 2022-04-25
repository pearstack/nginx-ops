package io.github.pearstack.nginx.ops.module.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.pearstack.nginx.ops.module.system.mapper.SysUserMapper;
import io.github.pearstack.nginx.ops.module.system.pojo.SysUserDO;
import io.github.pearstack.nginx.ops.module.system.pojo.query.SysUserQuery;
import io.github.pearstack.nginx.ops.module.system.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @author lihao3
 * @description 针对表【sys_user】的数据库操作Service实现
 * @createDate 2022-04-25 15:05:15
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserDO>
    implements SysUserService {

  @Override
  public void list(SysUserQuery sysUserQuery) {

  }
}
