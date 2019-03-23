package com.jack.service;

import java.util.List;

import com.jack.entity.Product;
import com.jack.entity.ProductExample;

public interface ProductService {
	List<Product> selectByExample(ProductExample example);
}
