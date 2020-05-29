package com.chen.order.service.impl;

import com.chen.order.dto.OrderDTO;
import com.chen.order.enums.OrderStatusEnum;
import com.chen.order.enums.PayStatusEnum;
import com.chen.order.model.OrderMaster;
import com.chen.order.repository.OrderMasterRepository;
import com.chen.order.service.OrderService;
import com.chen.util.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 订单Service实现
 * <p>
 * @Author LeifChen
 * @Date 2020-05-29
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;


    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        // 订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtils.genUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(3));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
