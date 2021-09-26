package com.xionghl.service.impl;

import com.xionghl.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @Author:xionghl
 * @Date:2021/9/26 9:15 下午
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentHystrixService {


    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }
}
