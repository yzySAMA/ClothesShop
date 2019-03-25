package com.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jack.dao.ProductMapper;
import com.jack.entity.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-configs.xml")
public class TestPopularProducts{
	@Autowired
	ProductMapper productMapper;
	@Test
	public void tst(){
		List<Product> list = productMapper.doShowPopularProducts();
		for (Product product : list) {
			System.out.println(product);
		}
	}
}
