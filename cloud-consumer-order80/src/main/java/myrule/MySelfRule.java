package myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义  Ribbon 负载均衡 规则
 *
 *
 * 这个自定义配置类不能放在 @ComponentScan 所扫描的当前包下以及子包下，否则自定义的配置类就会被所有的 Ribbon 客户端所共享，达不到特殊化定制的目的了。
 *
 *主启动累的 @SpringBootApplication包含 ComponentScan  所以要新建一个包和主启动类不是同一层
 *
 * @Author:xionghl
 * @Date:2021/9/25 5:47 下午
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule IRule() {
        return new RandomRule();
    }
}
