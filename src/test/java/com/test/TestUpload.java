package com.test;

import org.junit.Test;

import com.jack.common.vo.JsonResult;

public class TestUpload extends TestBase{
	@Test
	public void testUpload() {
		Object bean = ctx.getBean("multipartResolver");
		System.out.println(bean);
	}
	@Test
	public void testJsonResult() {
		System.out.println(new JsonResult("Hello"));
	}
}
