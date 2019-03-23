package com.test;

import org.junit.Test;

import com.jack.entity.Product;
import com.jack.service.ProductService;

public class TestProduct extends TestBase{
	@Test
	public void testProduct() {
		ProductService ps = ctx.getBean("productServiceImpl",ProductService.class);
		Product record = new Product(null, "T血", 150.0, "d:/ghisud", "haoyong", 3, "1");
		ps.insertObject(record);
	}
	
	@Test
	public void testUpdateProduct() {
		ProductService ps = ctx.getBean("productServiceImpl",ProductService.class);
		Product record = new Product("10", "T血sss", 150.0, "d:/gdddhisud", "haoddyong", 30, "1");
		ps.updateProduct(record);
	}
}
