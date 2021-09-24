package com.xionghl.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/** 获取RestTemplate 对象给controller 让controller去远程调用服务提供者8001端口得服务
 * @Author:xionghl
 * @Date:2021/9/24 6:52 上午
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced  //开启 RestTemplate 负载均衡能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
