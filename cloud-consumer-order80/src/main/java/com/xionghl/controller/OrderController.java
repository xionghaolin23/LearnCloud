package com.xionghl.controller;

import com.xionghl.entity.CommonResult;
import com.xionghl.entity.Payment;
import com.xionghl.lb.LoadBalanced;
import com.xionghl.lb.LoadBalancedImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

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

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancedImpl loadBalanced;

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

    /**
     * 测试自定义的符在均衡规则
     *
     * @return
     */
    @GetMapping(value = "/consumer/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        if (instances == null || instances.isEmpty()) {
            return null;
        }
        // 调用自定义的负载均衡策略
        ServiceInstance serviceInstance = loadBalanced.getInstances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);

    }
}
