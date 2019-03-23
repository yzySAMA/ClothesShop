package com.jack.common.vo;

public class JsonResult {
	/**
	 * 状态码：1表示ok，0表示error
	 */
	private int state = 1;
	/** 状态信息：状态码对应的具体消息 */
	private String message = "ok";
	/**
	 * 正确数据（一般用于存储业务层返回的数据）
	 */
	private Object data;

	public JsonResult() {
	}

	public JsonResult(String message) {
		super();
		this.message = message;
	}

	public JsonResult(Object data) {
		super();
		this.data = data;
	}

	public JsonResult(Throwable e) {
		this.state = 0;
		this.message = e.getMessage();
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
