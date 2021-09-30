package com.xionghl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:xionghl
 * @Date:2021/9/30 10:21 下午
 */
@RestController
@RefreshScope  //支持Nacos的动态刷新
public class ConfigClientController {
    /**
     * 从nacos中取
     */
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("configclient/getconfiginfo")
    public String getConfigInfo() {
        return configInfo;
    }
}

