package com.jack.service;

import java.util.List;

import com.jack.entity.Product;

public interface ProductService {
	List<Product> findPageByPname(Integer startPage,Integer PageSize, String Pname);
}
