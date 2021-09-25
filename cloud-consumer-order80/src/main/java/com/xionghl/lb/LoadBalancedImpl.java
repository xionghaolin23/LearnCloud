package com.xionghl.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义算法的具体实现
 *  负载均衡算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标， 每次服务重启动后rest接口计数从1开始。1
 * @Author:xionghl
 * @Date:2021/9/25 8:33 下午
 */
@Component
public class LoadBalancedImpl implements LoadBalanced {

    //原子类 cas+自炫锁
    private AtomicInteger atomicInteger = new AtomicInteger(0);


    /**
     * 判断是第几次访问
     *
     * @return
     */
    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println("*****第几次访问，次数next: " + next);
        return next;
    }

    /** 返回的是哪台机器
     * 负载均衡算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标， 每次服务重启动后rest接口计数从1开始。1
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance getInstances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
