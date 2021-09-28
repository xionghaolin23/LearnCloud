package com.xionghl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:xionghl
 * @Date:2021/9/28 7:41 上午
 */
@RestController
@RefreshScope //这个注解
public class ConfigClientController {
    /**
     *  消费
     *  相当于配置了config后，就把config服务端里的变量引入进来了
     *  https://gitee.com/xionghaolin/springcloud-config/blob/master/config-test.yml
     */
    @Value("${dev.name}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
