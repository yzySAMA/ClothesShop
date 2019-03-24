package com.jack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.jack.common.vo.JsonResult;
import com.jack.entity.Orders;
import com.jack.service.AdminOrdersService;

@Controller
@RequestMapping("/orders/")
public class AdminOrdersController {
	
	@Autowired
	private AdminOrdersService ordersService;
	
	@RequestMapping("doOrderListUI")
	public String doOrderListUI() {
		return "admin/sys/ord_list";
	}
	
	/**
	 * 根据uid查询产品信息
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("doFindObject")
	@ResponseBody
	public JsonResult doFindObject(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "5") Integer pageSize) {
		PageInfo<Orders> pi = ordersService.findAllOrders(pageNum, pageSize);
		return new JsonResult(pi);
	}
	/**
	 * 根据uid删除信息
	 * @param id
	 * @return
	 */
	@RequestMapping("doDeleteOrderById")
	@ResponseBody
	public JsonResult doDeleteOrderById(String id) {
		ordersService.deleteOrderById(id);
		return new JsonResult("delete ok");
	}
	/**
	 * 一键删除无效订单
	 * @param id
	 * @return
	 */
	@RequestMapping("doDeleteOrderByState")
	@ResponseBody
	public JsonResult doDeleteOrderByState() {
		int rows = ordersService.deleteOrderByState();
		return new JsonResult("删除了" + rows + "条订单");
	}
}
