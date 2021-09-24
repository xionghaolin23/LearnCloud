package com.xionghl.controller;

import com.xionghl.entity.CommonResult;
import com.xionghl.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 消费者controller
 *
 * @Author:xionghl
 * @Date:2021/9/24 6:54 上午
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    //private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PROVIDER-SERVICE";

    @PostMapping("/consumer/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        log.info("新增调用开始....");
        CommonResult commonResult = restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        log.info(commonResult.toString());
        return commonResult;
    }


    @GetMapping("/consumer/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") String id) {
        log.info("查询调用开始....");
        CommonResult commonResult = restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        log.info(commonResult.toString());
        return commonResult;
    }
}
