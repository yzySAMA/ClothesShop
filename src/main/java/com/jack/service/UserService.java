package com.jack.service;

import com.jack.entity.User;

public interface UserService {
	/**用户注册*/
	int insertObject(User user);
	/**根据用户名保存用户修改信息*/
	int doUpdateUser(User user);
}
