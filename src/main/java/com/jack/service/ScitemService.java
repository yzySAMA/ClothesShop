package com.jack.service;

import com.jack.entity.Scitem;

public interface ScitemService  {
	/**添加商品到购物车*/
	int doAddScitem(Scitem scitem,String uid);
}
