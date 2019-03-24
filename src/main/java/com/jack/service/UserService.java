package com.jack.service;

import com.jack.entity.User;

public interface UserService {
	int insertObject(User user);
	int doLogin(User user);
}
