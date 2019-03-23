package com.jack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jack.common.vo.JsonResult;
import com.jack.entity.Category;
import com.jack.service.CategoryService;

@RequestMapping("/category/")
@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@RequestMapping("doFindAllCategory")
	@ResponseBody
	public JsonResult doFindAllCategory() {
		List<Category> list = categoryService.findAll();
		return new JsonResult(list);
	}
}
