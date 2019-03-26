package com.jack.controller;

import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.github.pagehelper.PageInfo;
import com.jack.common.vo.JsonResult;
import com.jack.common.vo.UUIDUtils;
import com.jack.entity.Product;
import com.jack.service.ProductService;

@Controller
@RequestMapping("/product/")
public class AdminProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("doDeleteObjectById")
	@ResponseBody
	public JsonResult doDeleteObjectById(String id) {
		productService.deleteObjectById(id);
		return new JsonResult("delete ok");
	}
	
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
	public JsonResult doSaveObject(Product record) throws Throwable, IOException {
		System.out.println(record);
		productService.insertObject(record);
		return new JsonResult("save oK");
	}

	@RequestMapping("doUploadImage")
	@ResponseBody
	public JsonResult doUploadImage(MultipartFile image) throws Throwable {
		// 图片上传
		// 设置图片名称，不能重复，可以使用uuid
		String picName = UUIDUtils.newShortUUID();

		// 获取文件名
		String oriName = image.getOriginalFilename();
		// 获取图片后缀
		String extName = oriName.substring(oriName.lastIndexOf("."));
		File dir = new File("D:/upload/static/assets/upload/");
		if(!dir.isDirectory()) {
			dir.mkdirs();
		}
		// 开始上传
		image.transferTo(new File("D:/upload/static/assets/upload/" + picName + extName));
		String url = "static/assets/upload/"+picName + extName;
		return new JsonResult(url);
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
