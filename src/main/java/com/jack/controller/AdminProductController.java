package com.jack.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.jack.common.vo.JsonResult;
import com.jack.entity.Product;
import com.jack.service.ProductService;

@Controller
@RequestMapping("/product/")
public class AdminProductController {

	@Autowired
	private ProductService productService;


	// 分页查询,模糊查询
	@RequestMapping("doFindObject")
	@ResponseBody
	public JsonResult doFindObject(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "5") Integer PageSize, String pName) {// @RequestParam初始化化值
		PageInfo<Product> pi = productService.findPageByPname(pageNum, PageSize, pName);
		return new JsonResult(pi);
	}

	// 添加商品信息
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(Product record, MultipartFile image) throws Throwable, IOException {
		// 图片上传
		// 设置图片名称，不能重复，可以使用uuid
		String picName = UUID.randomUUID().toString();

		// 获取文件名
		String oriName = image.getOriginalFilename();
		// 获取图片后缀
		String extName = oriName.substring(oriName.lastIndexOf("."));

		// 开始上传
		image.transferTo(new File("/static/assets/upload" + picName + extName));

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

	// 商品展示页面
	@RequestMapping("doProListUI")
	public String doProListUI() {
		return "admin/sys/pro_list";
	}

	/**
	 * 商品编辑
	 * 
	 * @return 商品编辑页面
	 */
	@RequestMapping("doProEdit")
	public String doProEdit() {
		return "admin/sys/pro_edit";
	}
}
