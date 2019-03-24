package com.jack.service;

import com.github.pagehelper.PageInfo;
import com.jack.entity.Product;

public interface ProductService {
	// 分页查询
	PageInfo<Product> findPageByPname(Integer startPage,Integer PageSize, String Pname);
	int insertObject(Product record);
	Product findProductByPid(String pid);
	int updateProduct(Product record);
}
