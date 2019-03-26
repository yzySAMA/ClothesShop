package com.jack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.dao.OrdersMapper;
import com.jack.entity.vo.MyOrderItemVo;
import com.jack.entity.vo.MyOrderVo;
import com.jack.service.MyOrderService;

@Service
public class MyOrderServiceImpl implements MyOrderService {
	
	@Autowired
	private OrdersMapper orderMapper;
	
	/**查询所有订单*/
	@Override
	public List<MyOrderVo> findAllOrders(String uid) {
		return orderMapper.findAllOrders(uid);
	}
	
	/**查询封装好的订单项*/
	@Override
	public List<MyOrderItemVo> findMyOrderItemVo(String oid) {
		return orderMapper.findMyOrderItemVo(oid);
		
	}

}
