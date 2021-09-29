package com.xionghl.comtroller;

import com.xionghl.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:xionghl
 * @Date:2021/9/29 8:07 上午
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        // 自己定义的方法，但是里面调用了MessageChannel.send()方法
        return messageProvider.send();
    }
}
