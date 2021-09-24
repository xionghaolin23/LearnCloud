package com.xionghl.service.impl;

/**
 * @Author:xionghl
 * @Date:2021/9/23 10:25 下午
 */

import com.xionghl.dao.PaymentDao;
import com.xionghl.entity.Payment;
import com.xionghl.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl  implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }

}
