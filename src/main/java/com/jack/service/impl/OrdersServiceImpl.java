package com.jack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
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
	 * 查询所有订单信息
	 */

	@Override
	public List<Orders> findAllOrders(Integer startPage, Integer pageSize) {
		// 分页查询
		PageHelper.startPage(startPage, pageSize);
		List<Orders> list = ordersMapper.selectByExample(null);
		if (list == null || list.size() == 0) {
			throw new ServiceException("未查询到订单");
		}
		return list;
	}
	

}
