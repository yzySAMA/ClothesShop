package com.jack.dao;

import com.jack.entity.Orders;
import com.jack.entity.OrdersExample;
import com.jack.entity.vo.MyOrderItemVo;
import com.jack.entity.vo.MyOrderVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersMapper {
	/**查询所有订单*/
	List<MyOrderVo> findAllOrders(String uid);
	/**查询封装好的订单项*/
	List<MyOrderItemVo> findMyOrderItemVo(String oid);
	
    int countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(String oid);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(String oid);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

	

	

	
}