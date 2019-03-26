package com.jack.service;

import java.util.List;

import com.jack.entity.Scitem;
import com.jack.entity.vo.MyCartItemVo;

public interface ScitemService  {
	/**添加商品到购物车*/
	int doAddScitem(Scitem scitem,String uid);
	/**展示购物车信息*/
	List<MyCartItemVo> doShowCartList(String uid);
	/**删除购物项*/
	int doDeleteScitem(String[] array);
}
