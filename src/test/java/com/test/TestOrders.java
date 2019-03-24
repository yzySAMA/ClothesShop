package com.test;

import java.util.List;

import org.junit.Test;

import com.jack.entity.Orders;
import com.jack.service.OrdersService;

public class TestOrders extends TestBase{
	@Test
	public void testProduct() {
		OrdersService ps = ctx.getBean("ordersServiceImpl",OrdersService.class);
//		List<Orders> list = ps.findOrderByUid("1");
//		System.out.println(list);
		
	}
	
}
