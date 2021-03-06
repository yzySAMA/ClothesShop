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
	//加载分页
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "admin/common/page";
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

	@RequestMapping("cartUI")
	public String cartUI() {
		return "cart";
	}
	
	
	@RequestMapping("doLoginUI")
	public String doLoginUI() {
		return "login";
	}
	
	@RequestMapping("userEdit")
	public String editUser(){
		return "user_edit";
	}
	

}
