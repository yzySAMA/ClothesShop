package com.jack.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;
import com.jack.common.exception.ServiceException;
import com.jack.common.vo.JsonResult;
import com.jack.entity.User;
import com.jack.service.AdminUserService;

@RequestMapping("/user/")
@Controller
public class AdminUserController {
	@Autowired
	private AdminUserService adminUserService;

	/** 分页查询页面信息 */
	@RequestMapping("doFindObject")
	@ResponseBody
	public JsonResult doFindObject(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "5") Integer pageSize, String username) {

		PageInfo<User> pi = adminUserService.findPageByUsername(pageNum, pageSize, username);
		return new JsonResult(pi);
	}

	/** 用户列表页面 */
	@RequestMapping("doUserListUI")
	public String doUsreListUI() {
		return "admin/sys/user_list";
	}

	/**
	 * 用户信息导出
	 * 
	 * @param response
	 */
	@RequestMapping("doExportUserFile")
	public void doExportUserFile(HttpServletResponse response) {
		List<User> userList = adminUserService.findAllObjects();
		if (userList != null && userList.size() > 0) {
			String fileName = "UserMessage.xls";
			try {
				response.setHeader("Content-disposition",
						"attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO8859-1"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // 设置文件头编码格式
			response.setContentType("APPLICATION/OCTET-STREAM;charset=UTF-8");// 设置类型
			response.setHeader("Cache-Control", "no-cache");// 设置头
			response.setDateHeader("Expires", 0);// 设置日期头

			// 这里是表格的头部
			String[] titles = { "ID", "用户名", "姓名", "邮箱", "联系方式", "性别" };

			try {
				// 第一步，创建一个workbook，对应一个Excel文件
				HSSFWorkbook workbook = new HSSFWorkbook();

				// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
				HSSFSheet hssfSheet = workbook.createSheet("sheet1");

				// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short

				HSSFRow row = hssfSheet.createRow(0);
				// 第四步，创建单元格，并设置值表头 设置表头居中
				HSSFCellStyle hssfCellStyle = workbook.createCellStyle();

				// 居中样式
				hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

				HSSFCell hssfCell = null;
				for (int i = 0; i < titles.length; i++) {
					hssfCell = row.createCell(i);// 列索引从0开始
					hssfCell.setCellValue(titles[i]);// 列名1
					hssfCell.setCellStyle(hssfCellStyle);// 列居中显示
				}
				// 第五步，写入实体数据

				for (int i = 0; i < userList.size(); i++) {
					row = hssfSheet.createRow(i + 1);
					User user = userList.get(i);

					// 第六步，创建单元格，并设置值
					row.createCell(0).setCellValue(user.getUid());
					row.createCell(1).setCellValue(user.getUsername());
					row.createCell(2).setCellValue(user.getName());
					row.createCell(3).setCellValue(user.getEmail());
					row.createCell(4).setCellValue(user.getTelephone());
					row.createCell(5).setCellValue(user.getSex());
				}

				// 第七步，将文件输出到客户端浏览器
				try {
					workbook.write(response.getOutputStream());
					response.getOutputStream().flush();
					response.getOutputStream().close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				System.out.println("导出信息失败！");
				e.printStackTrace();
			}
		} else {
			System.out.println("查询结果为空!");
		}
	}

	/** 管理员登录 */
	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin(String username, String password, HttpSession session) {
		if (StringUtils.isEmpty(username)) {
			throw new ServiceException("用户名不能为空");
		}
		if (!"admin".equals(username)) {
			throw new ServiceException("用户名或密码不正确");
		}
		SimpleHash pwd = new SimpleHash("MD5", password);
		String apwd = pwd.toHex();
		if (StringUtils.isEmpty(password)||!"e10adc3949ba59abbe56e057f20f883e".equals(apwd)) {
			throw new ServiceException("用户名或密码不正确");
		}
		if ("e10adc3949ba59abbe56e057f20f883e".equals(apwd)) {
			session.setAttribute("login_admin", username);
		}
		return new JsonResult("login ok");
	}

	/** 管理员注销 */
	@RequestMapping("doLogout")
	public String doLogout(HttpSession session) {
 		//session.removeAttribute("login_admin");
		session.setAttribute("login_admin", null);
		return "redirect:../adminLoginUI";
	}
}
