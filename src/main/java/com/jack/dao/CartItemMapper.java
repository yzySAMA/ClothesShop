package com.jack.dao;

import java.util.List;

import com.jack.entity.vo.MyCartItemVo;

public interface CartItemMapper {
	
	List<MyCartItemVo> doShowCartList(String scid);
	
}
