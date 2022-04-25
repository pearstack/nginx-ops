package io.github.pearstack.nginx.ops;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author lihao3
 * @since 2022/4/25
 */
@MapperScan("io.github.pearstack.nginx.ops.module.*.mapper")
@RefreshScope
@SpringBootApplication
@EnableDiscoveryClient
public class NginxOpsWebApplication {

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

  public static void main(String[] args) {
    SpringApplication.run(NginxOpsWebApplication.class, args);
  }
}
