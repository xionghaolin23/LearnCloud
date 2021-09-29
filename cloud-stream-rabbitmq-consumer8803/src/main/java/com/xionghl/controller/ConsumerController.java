package com.xionghl.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

/** 接收消息的
 * @Author:xionghl
 * @Date:2021/9/29 8:14 上午
 */
@RestController
@EnableBinding(Sink.class)
@Slf4j
public class ConsumerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT) // 消费者
    public void input(Message<String> message) {
        log.info("消费者2号，serverPort: " + serverPort + "，接受到的消息：" + message.getPayload());
    }
}
