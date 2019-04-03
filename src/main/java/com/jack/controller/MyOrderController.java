package com.jack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jack.common.vo.JsonResult;
import com.jack.entity.User;
import com.jack.entity.vo.MyOrderItemVo;
import com.jack.entity.vo.MyOrderVo;
import com.jack.service.MyOrderService;

@Controller
@RequestMapping("/myOrder/")
public class MyOrderController {

	@Autowired
	private MyOrderService myOrderService;
	
	/**我的订单信息展示*/
	@RequestMapping("doMyOrder")
	@ResponseBody
	public JsonResult doMyOrder(User user) {
		System.out.println(user);
		List<MyOrderVo> MyOrderVoList=myOrderService.findAllOrders(user.getUid());
		for (MyOrderVo myOrderVo : MyOrderVoList) {
			String oid = myOrderVo.getOid();
			//查询封装好的订单项
			List<MyOrderItemVo> MyOrderItemVoList=myOrderService.findMyOrderItemVo(oid);
			for (MyOrderItemVo myOrderItemVo : MyOrderItemVoList) {
				System.out.println(myOrderItemVo);
				myOrderVo.getMyOrderItemVoList().add(myOrderItemVo);
			}
		}
		System.out.println(MyOrderVoList);
		return new JsonResult(MyOrderVoList);
	}
}
