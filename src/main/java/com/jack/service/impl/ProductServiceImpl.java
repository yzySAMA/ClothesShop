package com.jack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.dao.ProductMapper;
import com.jack.entity.Product;
import com.jack.entity.ProductExample;
import com.jack.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<Product> selectByExample(ProductExample example) {
		List<Product> selectByExample = productMapper.selectByExample(null);
		return selectByExample;
	}

}
