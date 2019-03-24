package com.jack.service;

import com.github.pagehelper.PageInfo;
import com.jack.entity.Orders;

public interface OrdersService {
	// 根据uid查询订单信息 
	PageInfo<Orders> findAllOrders(Integer startPage, Integer pageSize);
}
