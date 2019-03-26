package com.jack.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.jack.entity.Product;

public interface ProductService {
	// 分页查询
	PageInfo<Product> findPageByPname(Integer startPage,Integer PageSize, String Pname);
	int insertObject(Product record);
	Product findProductByPid(String pid);
	int updateProduct(Product record);
	
	/**首页热门商品获取  */
	List<Product> doShowPopularProducts();
	/**根据pid查询单个商品信息*/
	Product doShowSingleProduct(String pid);
	/**展示首页相应类别商品信息*/
	List<Product> doShowCategoryProducts(String cid);
}
