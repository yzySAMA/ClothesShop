package com.jack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.jack.common.vo.JsonResult;
import com.jack.entity.Product;
import com.jack.entity.ProductExample;
import com.jack.service.ProductService;

@Controller
@RequestMapping("/product/")
public class ProductController {
	@Autowired
	private ProductService productService;
	@RequestMapping("getAllProduct")
	@ResponseBody
	public JsonResult getAllproduct(@RequestParam(required = false, defaultValue = "1") Integer startPage,
	            @RequestParam(required = false, defaultValue = "5") Integer PageSize, String pName) {
	        PageHelper.startPage(startPage, PageSize);
	        ProductExample example = new ProductExample();
	        example.createCriteria().andPnameLike("%" + pName + "%");
//	        System.out.println(example);
	        List<Product> list = productService.selectByExample(example);
	        return new JsonResult(list);
	    }
}
