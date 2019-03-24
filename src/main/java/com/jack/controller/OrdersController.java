package com.jack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jack.common.vo.JsonResult;
import com.jack.entity.Orders;
import com.jack.service.OrdersService;

@Controller
@RequestMapping("/orders/")
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	// 根据uid查询产品信息
	@RequestMapping("doFindObject")
	@ResponseBody
	public JsonResult doFindObject(@RequestParam(required = false, defaultValue = "1") Integer startPage,
			@RequestParam(required = false, defaultValue = "5") Integer pageSize) {
		List<Orders> list = ordersService.findAllOrders(startPage, pageSize);
		return new JsonResult(list);
	}
	
}
