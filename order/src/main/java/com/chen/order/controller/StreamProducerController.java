package com.chen.order.controller;

import com.chen.order.dto.OrderDTO;
import com.chen.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Stream发送消息
 * <p>
 * @Author LeifChen
 * @Date 2020-06-13
 */
@RestController
public class StreamProducerController {

    @Autowired
    private StreamClient streamClient;

    /**
     * 发送 orderDTO 对象
     */
    @GetMapping("/sendMessage")
    public void process() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123456");
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
