package com.chen.order.repository;

import com.chen.order.model.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 订单Repository
 * <p>
 * @Author LeifChen
 * @Date 2020-05-29
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
