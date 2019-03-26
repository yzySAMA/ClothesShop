package com.jack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.dao.OrdersMapper;
import com.jack.entity.Orders;
import com.jack.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService{
	@Autowired
	OrdersMapper ordersMapper;
	@Override
	public int doChangeOrder(Orders order) {
		order.setState(1);
		int rows = ordersMapper.updateByPrimaryKeySelective(order);
		return rows;
	}
}
