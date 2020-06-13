package com.chen.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Stream收发消息通道
 * <p>
 * @Author LeifChen
 * @Date 2020-06-13
 */
public interface StreamClient {

    String INPUT = "input";
    String OUTPUT = "output";

    /**
     * 自定义收数据通道
     * @return
     */
    @Input(INPUT)
    SubscribableChannel input();

    /**
     * 自定义发数据通道
     * @return
     */
    @Output(OUTPUT)
    MessageChannel output();
}
