package com.jack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.common.exception.ServiceException;
import com.jack.dao.CategoryMapper;
import com.jack.entity.Category;
import com.jack.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryMapper categoryMapper;
	/**
	 * 	获得所有的商品类别
	 */
	@Override
	public List<Category> findAll() {
		List<Category> list = categoryMapper.selectByExample(null);
		if(list == null) {
			throw new ServiceException("没有查到对应的记录");
		}
		return list;
	}
	
}
