package com.chen.order.service;


import com.chen.order.dto.OrderDTO;

/**
 * 订单Service接口
 * <p>
 * @Author LeifChen
 * @Date 2020-05-29
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 完结订单(只能卖家操作)
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);
}
