package com.jack.service;

import java.util.List;

import com.jack.entity.vo.MyOrderItemVo;
import com.jack.entity.vo.MyOrderVo;

public interface MyOrderService {
	/**查询所有订单*/
	List<MyOrderVo> findAllOrders(String uid);

	/**查询封装好的订单项*/
	List<MyOrderItemVo> findMyOrderItemVo(String oid);

}
