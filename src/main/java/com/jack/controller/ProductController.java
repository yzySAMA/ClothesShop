package com.jack.controller;

import java.util.List;

import com.jack.dao.ProductMapper;
import com.jack.entity.ProductExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jack.common.vo.JsonResult;
import com.jack.entity.Product;
import com.jack.service.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {	
	@Autowired
	ProductService productService;

	@Autowired
	ProductMapper productMapper;
	
	/**首页热门商品获取*/
	@RequestMapping("doShowPopularProducts")
	@ResponseBody
	public JsonResult doShowPopularProducts(){
		List<Product> productList = productService.doShowPopularProducts();
		return new JsonResult(productList);
	}
	
	/**根据pid查询单个商品信息*/
	@RequestMapping("doShowSingleProduct")
	@ResponseBody
	public JsonResult doShowSingleProduct(String pid){
		Product doShowSingleProduct = productService.doShowSingleProduct(pid);
		return new JsonResult(doShowSingleProduct);
	}
	
	/**首页类别商品获取*/
	@RequestMapping("doShowCategoryProducts")
	@ResponseBody
	public JsonResult doShowCategoryProducts(String cid){
		List<Product> productList = productService.doShowCategoryProducts(cid);
		return new JsonResult(productList);
	}

	/**首页商品搜索*/
	@RequestMapping("doHomePageSearch")
	@ResponseBody
	public JsonResult doHomePageSearch(String keyWords){
		ProductExample example = new ProductExample();
		example.createCriteria().andPnameLike("%"+keyWords+"%");
		List<Product> products = productMapper.selectByExample(example);
		return new JsonResult(products);
	}

	
}
