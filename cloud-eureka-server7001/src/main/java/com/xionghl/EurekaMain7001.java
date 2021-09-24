package com.xionghl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author:xionghl
 * @Date:2021/9/24 8:09 上午
 */
@SpringBootApplication
@EnableEurekaServer //标记自己是服务端 代表是服务注册中心 主要干的活就是服务注册，不需要写业务类
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}
