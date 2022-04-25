package io.github.pearstack.nginx.ops.module.system.api.server.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.pearstack.nginx.ops.module.system.api.pojo.vo.SysUserVO;
import io.github.pearstack.nginx.ops.module.system.api.service.SysUserApiService;
import io.github.pearstack.nginx.ops.module.system.pojo.SysUserDO;
import io.github.pearstack.nginx.ops.module.system.service.SysUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author lihao3
 * @since 2022/4/25
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SysUserApiServiceImpl implements SysUserApiService {

  private final SysUserService sysUserService;
  private final LambdaQueryWrapper<SysUserDO> sysUserDOLambdaQueryWrapper =
      new LambdaQueryWrapper<>();

  @Override
  public SysUserVO getOne(String username) {
    sysUserDOLambdaQueryWrapper.clear();
    sysUserDOLambdaQueryWrapper.eq(SysUserDO::getEnable, true).eq(SysUserDO::getUsername, username);
    SysUserDO sysUserDO = sysUserService.getOne(sysUserDOLambdaQueryWrapper);
    return BeanUtil.copyProperties(sysUserDO, SysUserVO.class);
  }
}
