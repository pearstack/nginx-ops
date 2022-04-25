package io.github.pearstack.nginx.ops.module.system.controller;

import io.github.pearstack.nginx.ops.module.system.pojo.vo.Server;
import io.github.pearstack.nginx.ops.pojo.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihao3
 * @since 2022/4/25
 */
@Api(tags = "首页接口")
@Slf4j
@RestController
@RequestMapping("/system/home")
@RequiredArgsConstructor
public class SystemHomeController {

  @GetMapping
  @ApiOperation("查询系统运行信息")
  public R<Server> getServer() {
    return R.success("查询成功!", Server.init());
  }
}
