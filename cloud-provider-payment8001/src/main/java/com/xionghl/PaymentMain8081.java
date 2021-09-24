package com.xionghl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author:xionghl
 * @Date:2021/9/23 10:02 下午
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8081 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8081.class,args);
    }
}
