package com.chen.order.service.impl;

import com.chen.order.dto.OrderDTO;
import com.chen.order.enums.OrderStatusEnum;
import com.chen.order.enums.PayStatusEnum;
import com.chen.order.enums.ResultEnum;
import com.chen.order.exception.OrderException;
import com.chen.order.model.OrderDetail;
import com.chen.order.model.OrderMaster;
import com.chen.order.repository.OrderDetailRepository;
import com.chen.order.repository.OrderMasterRepository;
import com.chen.order.service.OrderService;
import com.chen.product.client.ProductClient;
import com.chen.util.KeyUtils;
import com.chen.vo.DecreaseStockInput;
import com.chen.vo.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 订单Service实现
 * <p>
 * @Author LeifChen
 * @Date 2020-05-29
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private ProductClient productClient;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = null;
        try {
            orderId = KeyUtils.genUniqueKey();
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(), e);
        }

        // 查询商品信息(调用商品服务)
        List<String> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(productIdList);

        // 计算总价
        BigDecimal orderAmount = BigDecimal.ZERO;
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            for (ProductInfoOutput productInfo : productInfoList) {
                if (productInfo.getProductId().equals(orderDetail.getProductId())) {
                    // 单价*数量
                    orderAmount = productInfo.getProductPrice()
                            .multiply(BigDecimal.valueOf(orderDetail.getProductQuantity()))
                            .add(orderAmount);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    try {
                        orderDetail.setDetailId(KeyUtils.genUniqueKey());
                    } catch (NoSuchAlgorithmException e) {
                        log.error(e.getMessage(), e);
                    }
                    // 订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }
        }

        // 扣库存(调用商品服务)
        List<DecreaseStockInput> decreaseStockInputList = orderDTO.getOrderDetailList().stream()
                .map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(decreaseStockInputList);

        // 订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }

    @Override
    @Transactional(rollbackOn = OrderException.class)
    public OrderDTO finish(String orderId) {
        // 1.先查询订单
        Optional<OrderMaster> orderMasterOptional = orderMasterRepository.findById(orderId);
        if (!orderMasterOptional.isPresent()) {
            throw new OrderException(ResultEnum.ORDER_NOT_EXIST);
        }

        // 2.判断订单状态
        OrderMaster orderMaster = orderMasterOptional.get();
        if (!OrderStatusEnum.NEW.getCode().equals(orderMaster.getOrderStatus())) {
            throw new OrderException(ResultEnum.ORDER_STATUS_ERROR);
        }

        // 3.修改订单状态为完结
        orderMaster.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        orderMasterRepository.save(orderMaster);

        // 查询订单详情
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)) {
            throw new OrderException(ResultEnum.ORDER_DETAIL_NOT_EXIST);
        }

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
