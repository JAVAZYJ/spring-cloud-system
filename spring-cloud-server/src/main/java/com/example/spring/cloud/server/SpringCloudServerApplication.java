package com.example.spring.cloud.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * SpringCloud Eureka注册中心
 * @author YiJieZhu
 * @since 2019年6月11日 20点15分
 */
@SpringBootApplication //启动项目注解
@EnableEurekaServer //启动Eureka注册中心注解
public class SpringCloudServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudServerApplication.class, args);
    }

}
