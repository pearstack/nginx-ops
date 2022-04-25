package io.github.pearstack.nginx.ops;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author lihao3
 * @since 2022/4/25
 */
@MapperScan("io.github.pearstack.nginx.ops.module.*.mapper")
@RefreshScope
@SpringBootApplication
@EnableDiscoveryClient
public class NginxOpsWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(NginxOpsWebApplication.class, args);
    }
}
