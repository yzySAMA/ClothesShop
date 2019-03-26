package com.jack.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jack.common.vo.JsonResult;
import com.jack.entity.User;
import com.jack.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	/**用户注册 */
	@RequestMapping("doRegister.do")
	@ResponseBody
	public JsonResult doRegister(User user) {
		userService.insertObject(user);
		return new JsonResult("注册成功！");
	}
	/**用户登录*/
	@RequestMapping("doLogin.do")
	@ResponseBody
	public JsonResult doLogin(String username,String password) {
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(username, password);
		subject.login(token);
		User user=(User)subject.getPrincipal();
		JsonResult js=new JsonResult();
		js.setMessage("登录成功");
		js.setData(user);
		return js;
	}
	/**进入用户信息修改页面*/
	@RequestMapping("doUserEditUI.do")
	public String doUserEditUI() {
		return "user_edit";
	}
	/**回显用户个人信息到信息修改页面*/
	@RequestMapping("doFindUser.do")
	@ResponseBody
	public JsonResult doFindUser() {
		User user=(User)SecurityUtils.getSubject().getPrincipal();
		return new JsonResult(user);
	}
	/**保存用户个人修改信息*/
	@RequestMapping("doSaveUser.do")
	@ResponseBody
	public JsonResult doSaveUser(User user) {
		userService.doUpdateUser(user);
		return new JsonResult("保存成功");
	}
	
	
}
