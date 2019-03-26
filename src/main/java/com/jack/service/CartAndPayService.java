package com.jack.service;

import com.jack.entity.Orders;

public interface CartAndPayService {
	/**点击购物车去结算 事件*/
	long insertOrder(Orders orders);
	int doDownProductCount(String pid,String count);
}
