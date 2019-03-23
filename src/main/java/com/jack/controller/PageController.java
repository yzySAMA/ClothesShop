package com.jack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {
	 @RequestMapping("/{page}")
	    public String page(@PathVariable String page){
	        return page;
	    }
	
	@RequestMapping("adminLoginUI")
	public String adminLogin() {
		return "admin/login";
	}
	
	@RequestMapping("startUI")
	public String StartUI() {
		return "admin/starter";
	}
	
	@RequestMapping("productList")
	public String productList() {
		return "product_list";
	}
	
	@RequestMapping("productInfo.do")
	public String productInfo() {
		return "product_Info";
	}


}
