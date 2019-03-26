package com.jack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jack.common.vo.JsonResult;
import com.jack.entity.Scitem;
import com.jack.entity.vo.MyCartItemVo;
import com.jack.service.ScitemService;

@Controller
@RequestMapping("/")
public class ScitemController {
	
	@Autowired
	ScitemService scitemService;

	@RequestMapping("doAddScitem")
	@ResponseBody
	public JsonResult doAddScitem(Scitem scitem,String uid){
		scitemService.doAddScitem(scitem,uid);
		return new JsonResult("添加成功");
	}
	
	@RequestMapping("doShowCartList")
	@ResponseBody
	public JsonResult doShowCartList(String uid){
		List<MyCartItemVo> doShowCartList = scitemService.doShowCartList(uid);
		return new JsonResult(doShowCartList);
	}
	
}
