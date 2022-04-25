package io.github.pearstack.nginx.ops.module.system.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.github.pearstack.nginx.ops.module.system.pojo.SysUserDO;
import io.github.pearstack.nginx.ops.module.system.pojo.query.SysUserQuery;
import io.github.pearstack.nginx.ops.module.system.service.SysUserService;
import io.github.pearstack.nginx.ops.pojo.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihao3
 * @since 2022/4/25
 */
@Api(tags = "用户接口")
@Slf4j
@RestController
@RequestMapping("/system/user")
@RequiredArgsConstructor
public class SystemUserController {

  private final SysUserService sysUserService;

  @GetMapping("/list")
  @ApiOperation("分页查询用户列表")
  public R<SysUserDO> selectPageList(@ModelAttribute SysUserQuery sysUserQuery) {
    Page<SysUserDO> page =
        PageHelper.startPage(
            sysUserQuery.getPageNum(), sysUserQuery.getPageSize(), sysUserQuery.getOrderBy());
    sysUserService.list(sysUserQuery);
    return R.success("查询成功!", page);
  }
}
