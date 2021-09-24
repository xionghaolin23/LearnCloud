package com.xionghl.service;

import com.xionghl.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author:xionghl
 * @Date:2021/9/23 10:24 下午
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
