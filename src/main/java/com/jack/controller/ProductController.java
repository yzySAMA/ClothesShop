package com.jack.controller;

import java.util.List;

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
	
}
