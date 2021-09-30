package con.xionghl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author:xionghl
 * @Date:2021/9/30 8:14 上午
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudalibabaConsumerNacosOrder83Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaConsumerNacosOrder83Application.class, args);
        System.out.println("启动成功");
    }

}
