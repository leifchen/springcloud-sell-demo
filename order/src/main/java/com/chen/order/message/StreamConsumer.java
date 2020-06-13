package com.chen.order.message;

import com.chen.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Stream接收消息
 * <p>
 * @Author LeifChen
 * @Date 2020-06-12
 */
@Slf4j
@Component
@EnableBinding(StreamClient.class)
public class StreamConsumer {

    /**
     * 接收orderDTO对象消息
     * @param message
     */
    @StreamListener(value = StreamClient.INPUT)
    @SendTo(StreamClient.OUTPUT)
    public String process(OrderDTO message) {
        log.info("StreamReceiver: {}", message);
        return "received.";
    }

    @StreamListener(value = StreamClient.OUTPUT)
    public void process2(String message) {
        log.info("StreamReceiver2: {}", message);
    }
}
