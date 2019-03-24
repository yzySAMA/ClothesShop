package com.jack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.jack.common.vo.JsonResult;
import com.jack.entity.Orders;
import com.jack.service.OrdersService;

@Controller
@RequestMapping("/orders/")
public class AdminOrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	@RequestMapping("doOrderListUI")
	public String doOrderListUI() {
		return "admin/sys/ord_list";
	}
	
	// 根据uid查询产品信息
	@RequestMapping("doFindObject")
	@ResponseBody
	public JsonResult doFindObject(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "5") Integer pageSize) {
		PageInfo<Orders> pi = ordersService.findAllOrders(pageNum, pageSize);
		return new JsonResult(pi);
	}
	
}
