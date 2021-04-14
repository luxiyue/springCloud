package org.lzl.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)//只要8801发送消息，8802就会接收到8801的消息
    public void input(Message<String> message){
        System.out.println("消费者2号--------》接收到的消息："+message.getPayload()+"\t port: "+serverPort);
    }

}
