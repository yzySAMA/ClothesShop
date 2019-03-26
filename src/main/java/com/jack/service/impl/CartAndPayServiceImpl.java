package com.jack.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.common.exception.ServiceException;
import com.jack.common.vo.UUIDUtils;
import com.jack.dao.OrdersMapper;
import com.jack.dao.ProductMapper;
import com.jack.entity.Orders;
import com.jack.service.CartAndPayService;

@Service
public class CartAndPayServiceImpl implements CartAndPayService{
	@Autowired
	OrdersMapper ordersMapper;
	@Autowired
	ProductMapper productMapper;
	
	/**点击购物车去结算 事件*/
	@Override
	public long insertOrder(Orders orders) {
		String suuid = UUIDUtils.newShortUUID();
		orders.setOid(suuid);
		orders.setState(0);
		orders.setOrdertime(new Date());
		int rows = ordersMapper.insert(orders);
		
		if (rows == 0) {
			throw new ServiceException("系统错误");
		}
		Long in = Long.parseLong(suuid,16);
		return in;
	}

	@Override
	public int doDownProductCount(String pid, String count) {
		// TODO Auto-generated method stub
		Integer count1 = Integer.parseInt(count);
		productMapper.updateProductCount(pid, count1);
		return 0;
	}
}
