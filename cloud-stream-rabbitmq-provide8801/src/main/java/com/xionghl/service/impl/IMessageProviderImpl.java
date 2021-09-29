package com.xionghl.service.impl;

import com.xionghl.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/** 业务类：（此业务类不是以前的service，而实负责推送消息的服务类）
 * @Author:xionghl
 * @Date:2021/9/29 8:03 上午
 */
@EnableBinding(Source.class)  // 定义消息的推送管道 output//不是和controller打交道的service,而是发送消息的推送服务类
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {

    @Resource(name="output")
    private MessageChannel outputChannel;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        //绑定器
        outputChannel.send(MessageBuilder.withPayload(serial).build());
        log.info("******serial: " + serial);
        return null;
    }
}
