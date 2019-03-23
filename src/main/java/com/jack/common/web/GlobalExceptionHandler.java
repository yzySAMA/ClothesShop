package com.jack.common.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jack.common.vo.JsonResult;
import com.jack.exception.ServiceException;

/**
 * @ControllerAdvice修饰的类一般为spring mvc中的全局异常处理类， 此类中可以定义一些异常处理办法
 * @author LYY
 * @RestControllerAdvice也可以修饰 全局
 */
@RestControllerAdvice
//@ControllerAdvice
public class GlobalExceptionHandler {

	
	/*
	 * @ExceptionHandler(ShiroException.class) // @ResponseBody public JsonResult
	 * doHandleShiroException(ShiroException e) { JsonResult r = new JsonResult();
	 * r.setState(0); if(e instanceof UnknownAccountException) {
	 * r.setMessage("账户不存在"); } else if(e instanceof LockedAccountException) {
	 * r.setMessage("账户被锁定"); } else if(e instanceof IncorrectCredentialsException)
	 * { r.setMessage("密码不正确"); } else if(e instanceof AuthorizationException) {
	 * r.setMessage("没有权限"); } else { r.setMessage(e.getMessage()); } return r; }
	 */
	@ExceptionHandler(RuntimeException.class)
	public JsonResult doHandleRuntimeException(RuntimeException e) {
		e.printStackTrace();
		JsonResult r = new JsonResult();
		r.setMessage("运行时错误");
		r.setState(0);
		return r;
	}
	/**
	 * 	自定义服务异常
	 * @param e 错误信息
	 * @return 以Json形式返回
	 */
	@ExceptionHandler(ServiceException.class)
	public JsonResult doHandleServiceException(ServiceException e) {
		e.printStackTrace();
		return new JsonResult(e);
	}
}