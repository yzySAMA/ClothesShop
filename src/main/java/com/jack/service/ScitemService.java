package com.jack.service;

import java.util.List;

import com.jack.entity.Scitem;
import com.jack.entity.vo.MyCartItemVo;

public interface ScitemService  {
	/**添加商品到购物车*/
	int doAddScitem(Scitem scitem,String uid);
	
	List<MyCartItemVo> doShowCartList(String uid);
}
