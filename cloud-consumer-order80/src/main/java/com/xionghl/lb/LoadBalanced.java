package com.xionghl.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/** 自定义轮训算法接口
 * @Author:xionghl
 * @Date:2021/9/25 8:33 下午
 */
public interface LoadBalanced {

    /**
     * 收集服务器总共有多少台能够提供服务的机器，并放到list里面
     * @param serviceInstances
     * @return
     */
    ServiceInstance  getInstances(List<ServiceInstance> serviceInstances);
}
