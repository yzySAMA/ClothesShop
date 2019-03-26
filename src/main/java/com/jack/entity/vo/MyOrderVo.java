package com.jack.entity.vo;

import java.util.ArrayList;
import java.util.List;

public class MyOrderVo {
	//订单编号
	private String  oid;
	//订单状态
	private int state;
	//订单项对象
	private List<MyOrderItemVo> myOrderItemVoList=new ArrayList<MyOrderItemVo>();
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

	public List<MyOrderItemVo> getMyOrderItemVoList() {
		return myOrderItemVoList;
	}
	public void setMyOrderItemVoList(List<MyOrderItemVo> myOrderItemVoList) {
		this.myOrderItemVoList = myOrderItemVoList;
	}
	@Override
	public String toString() {
		return "MyOrderVo [oid=" + oid + ", state=" + state + ", myOrderItemVoList=" + myOrderItemVoList + "]";
	}

	
	
}
