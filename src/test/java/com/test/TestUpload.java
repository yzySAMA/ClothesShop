package com.test;

import org.junit.Test;

public class TestUpload extends TestBase{
	@Test
	public void testUpload() {
		Object bean = ctx.getBean("multipartResolver");
		System.out.println(bean);
	}
}
