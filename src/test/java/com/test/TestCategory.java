package com.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jack.dao.CategoryMapper;
import com.jack.entity.Category;
import com.jack.entity.CategoryExample;
import com.jack.entity.CategoryExample.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-configs.xml")
public class TestCategory {
	@Autowired
	private CategoryMapper cm;
	@Test
	public void testFindAll() {
		CategoryExample ce = new CategoryExample();
		Criteria criteria = ce.createCriteria();
		List<Category> result = cm.selectByExample(null);
		System.out.println(result);
	}
}
