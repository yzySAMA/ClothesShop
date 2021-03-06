package com.jack.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.jack.entity.Orders;

public interface AdminOrdersService {
	// 查询订单信息 
	PageInfo<Orders> findAllOrders(Integer startPage, Integer pageSize);
	// 根据id删除订单信息
	int deleteOrderById(String oid);
	// 删除无效订单
	int deleteOrderByState();
	//查询所有订单信息用于订单信息导出到Excel
	List<Orders> findAllObjects();
}
