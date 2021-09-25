package com.xionghl.service;

import com.xionghl.entity.CommonResult;
import com.xionghl.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 业务逻辑接口 + @FeignClient 配置调用provider服务
 *
 * @Author:xionghl
 * @Date:2021/9/26 6:34 上午
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-SERVICE")  //指定调用哪个微服务
public interface PaymentFeignService {
    /**
     * 哪个地址
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
