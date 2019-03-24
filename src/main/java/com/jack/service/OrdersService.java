package com.jack.service;

import java.util.List;

import com.jack.entity.Orders;

public interface OrdersService {
	// 根据uid查询订单信息 
	List<Orders> findOrdersByUid(String uid);
}
