package com.jack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jack.common.vo.JsonResult;
import com.jack.common.vo.UUIDUtils;
import com.jack.dao.OrderitemMapper;
import com.jack.dao.ScitemMapper;
import com.jack.entity.Orderitem;
import com.jack.entity.Orders;
import com.jack.service.CartAndPayService;
import com.jack.service.OrdersService;

@Controller
public class CartAndPayController {
	
	@Autowired
	CartAndPayService cartAndPayService;
	@Autowired
	OrdersService ordersService;
	@Autowired
	ScitemMapper scitemMapper;
	@Autowired
	OrderitemMapper orderitemMapper;
	
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
		return new JsonResult();
	}
	
	@RequestMapping("doChangeOrder")
	@ResponseBody
	public JsonResult doChangeOrder(Orders order,String[] arr2){
		//删除购物车中已经购买的东西
		for(String id : arr2){
			scitemMapper.deleteByPrimaryKey(id);
		}
		ordersService.doChangeOrder(order);
		return new JsonResult("支付成功");
	}
	
	@RequestMapping("doInsertOrderItem")
	@ResponseBody
	public JsonResult doInsertOrderItem(String[] arrcount,String[] arrtotal,String[] arrpid,String oid){
		//程序中还有各种异常及UUID重复等小概率事件没考虑，比较粗糙，时间来不及了
		for(int i = 0;i<arrcount.length;i++){
			Orderitem orderitem = new Orderitem();
			orderitem.setItemid(UUIDUtils.newShortUUID());
			orderitem.setCount(Integer.parseInt(arrcount[i]));
			orderitem.setSubtotal(Double.parseDouble(arrtotal[i]));
			orderitem.setPid(arrpid[i]);
			orderitem.setOid(oid);
			orderitemMapper.insert(orderitem);
		}
		return new JsonResult();
	}
	
	
}


