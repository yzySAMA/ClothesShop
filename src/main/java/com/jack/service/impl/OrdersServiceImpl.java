package com.jack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.jack.common.exception.ServiceException;
import com.jack.dao.OrdersMapper;
import com.jack.entity.Orders;
import com.jack.entity.OrdersExample;
import com.jack.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	private OrdersMapper ordersMapper;
	/**
	 * 根据userId查询订单信息
	 */
	@Override
	public List<Orders> findOrdersByUid(String uid) {
		if (StringUtils.isEmpty(uid)) {
			throw new ServiceException("未登录");
		}
		OrdersExample example = new OrdersExample();
		example.createCriteria().andUidEqualTo(uid);
		List<Orders> list = ordersMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			throw new ServiceException("未查询到订单");
		}
		return list;
	}


}
