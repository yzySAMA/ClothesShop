package com.test;

import java.util.List;

import org.junit.Test;

import com.jack.entity.vo.MyCartItemVo;
import com.jack.service.ScitemService;

public class TestSpring extends TestBase{
	
	@Test
	public void testSpring() {
		ScitemService mapper =  ctx.getBean(ScitemService.class);
		List<MyCartItemVo> doShowCartList = mapper.doShowCartList("7f9a6518");
		for (MyCartItemVo myCartItemVo : doShowCartList) {
			System.out.println("=====");
			System.out.println(myCartItemVo);
		}
	}
}
