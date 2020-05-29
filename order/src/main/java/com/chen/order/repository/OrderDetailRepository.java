package com.chen.order.repository;

import com.chen.order.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 订单详情Repository
 * <p>
 * @Author LeifChen
 * @Date 2020-05-29
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

	/**
	 * 根据订单id查询订单详情列表
	 * @param orderId
	 * @return
	 */
	List<OrderDetail> findByOrderId(String orderId);
}
