package com.xionghl.controller;

import com.xionghl.entity.CommonResult;
import com.xionghl.entity.Payment;
import com.xionghl.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author:xionghl
 * @Date:2021/9/23 10:27 下午
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 只传给前端CommonResult，不需要前端了解其他的组件
     */
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);
        log.info("因为做的是集群，所以看看80用户请求打到哪台服务器上，请求服务端的端口为：" + serverPort);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功："+serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败："+serverPort, null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        System.out.println(payment);
        log.info("*****查询结果：" + payment);
        log.info("因为做的是集群，所以看看80用户请求打到哪台服务器上，请求服务端的端口为：" + serverPort);
        if (payment != null) {
            return new CommonResult(200, "查询成功："+serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID：" + id+"端口："+serverPort, null);
        }
    }

}
