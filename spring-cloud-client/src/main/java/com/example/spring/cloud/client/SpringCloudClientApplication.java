package com.example.spring.cloud.client;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author YiJieZhu
 * @since 2019年6月11日 20点30分
 */
@SpringBootApplication //启动项目注解
@EnableEurekaClient //启动Eureka服务中心注解
public class SpringCloudClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudClientApplication.class, args);
    }

}
