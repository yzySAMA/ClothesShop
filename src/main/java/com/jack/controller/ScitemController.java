package com.jack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jack.common.vo.JsonResult;
import com.jack.entity.Scitem;
import com.jack.service.ScitemService;

@Controller
@RequestMapping("/")
public class ScitemController {
	
	@Autowired
	ScitemService scitemService;

	@RequestMapping("doAddScitem")
	@ResponseBody
	public JsonResult doAddScitem(Scitem scitem){
		scitemService.doAddScitem(scitem);
		return new JsonResult("添加成功");
	}
}
