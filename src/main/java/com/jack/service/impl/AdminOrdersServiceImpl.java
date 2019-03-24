package com.jack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jack.common.exception.ServiceException;
import com.jack.dao.OrdersMapper;
import com.jack.entity.Orders;
import com.jack.entity.OrdersExample;
import com.jack.service.AdminOrdersService;

@Service
public class AdminOrdersServiceImpl implements AdminOrdersService {
	@Autowired
	private OrdersMapper ordersMapper;
	/**
	 * 查询所有订单信息
	 */

	@Override
	public PageInfo<Orders> findAllOrders(Integer startPage, Integer pageSize) {
		// 分页查询
		PageHelper.startPage(startPage, pageSize);
		OrdersExample example = new OrdersExample();
		example.setOrderByClause("ordertime DESC");
		List<Orders> list = ordersMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			throw new ServiceException("未查询到订单");
		}
		PageInfo<Orders> pi = new PageInfo<>(list);
		return pi;
	}
	/**
	 * 根据id删除订单信息
	 */
	@Override
	public int deleteOrderById(String oid) {
		if (StringUtils.isEmpty(oid)) {
			throw new ServiceException("id为空");
		}
		int rows = ordersMapper.deleteByPrimaryKey(oid);
		if (rows < 0) {
			throw new ServiceException("记录可能已经不存在");
		}
		return rows;
	}
	/**
	 * 一键删除无效订单
	 */
	@Override
	public int deleteOrderByState() {
		OrdersExample example = new OrdersExample();
		example.createCriteria().andStateEqualTo(0);
		int rows = ordersMapper.deleteByExample(example);
		if (rows < 1) {
			throw new ServiceException("没有无效订单");
		}
		return rows;
	}
	

}
