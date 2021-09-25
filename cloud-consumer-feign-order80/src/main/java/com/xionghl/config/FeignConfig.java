package com.xionghl.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:xionghl
 * @Date:2021/9/26 6:50 上午
 */
@Configuration
public class FeignConfig {

    /**
     * NONE,
     * BASIC,
     * HEADERS,
     * FULL;
     * <p>
     * 日志级别
     *
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
