package com.jack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jack.common.vo.JsonResult;
import com.jack.entity.Orders;
import com.jack.service.CartAndPayService;
import com.jack.service.OrdersService;

@Controller
public class CartAndPayController {
	
	@Autowired
	CartAndPayService cartAndPayService;
	@Autowired
	OrdersService ordersService;
	
	/**跳转订单页面*/
	@RequestMapping("doPayOrderUI")
	public String doPayOrderUI() {
		return "payOrder";
	}
	
	/**提交支付订单页面数据*/
	@RequestMapping("doPayment")
	@ResponseBody
	public JsonResult doPayment(Orders orders){
		long insertOrder = cartAndPayService.insertOrder(orders);
		return new JsonResult(insertOrder);
	}
	
	@RequestMapping("doDownProductCount")
	@ResponseBody
	public JsonResult doDownProductCount(String pid,String count){
		cartAndPayService.doDownProductCount(pid,count);
		System.out.println(pid+count);
		return new JsonResult();
	}
	
	
	@RequestMapping("doChangeOrder")
	@ResponseBody
	public JsonResult doChangeOrder(Orders order){
		ordersService.doChangeOrder(order);
		return new JsonResult("支付成功");
	}
	
}


