package com.jack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jack.common.vo.JsonResult;
import com.jack.entity.Product;
import com.jack.service.ProductService;

@Controller
@RequestMapping("/product/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	// 分页查询,模糊查询
	@RequestMapping("doFindObject")
	@ResponseBody
	public JsonResult doFindObject(@RequestParam(required = false, defaultValue = "1") Integer startPage,
			@RequestParam(required = false, defaultValue = "5") Integer PageSize, String pName) {//@RequestParam初始化化值
		List<Product> list = productService.findPageByPname(startPage, PageSize, pName);
		return new JsonResult(list);
	}
	
	// 添加商品信息
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(Product record) {
		productService.insertObject(record);
		return new JsonResult("save oK");
	}
	
	// 根据id查询信息
	@RequestMapping("doFingObjectByPid")
	@ResponseBody
	public JsonResult doFingObjectByPid(String pid) {
		Product pro = productService.findProductByPid(pid);
		return new JsonResult(pro);
	}
	
	// 修改商品信息
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(Product record) {
		productService.updateProduct(record);
		return new JsonResult("update oK");
	}
	//商品展示页面
	@RequestMapping("doProListUI")
	public String doProListUI() {
		return "admin/sys/pro_list";
	}
}
