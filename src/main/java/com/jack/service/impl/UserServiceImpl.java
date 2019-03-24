package com.jack.service.impl;


import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.jack.common.exception.ServiceException;
import com.jack.common.vo.UUIDUtils;
import com.jack.dao.UserMapper;
import com.jack.entity.User;
import com.jack.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	//注册用户
	@Override
	public int insertObject(User user) {
		if(user==null)
			throw new ServiceException("用户不能为空！");
		if(StringUtils.isEmpty(user.getUsername())||StringUtils.isEmpty(user.getPassword()))
			throw new ServiceException("用户名和密码不能为空！");
		if(StringUtils.isEmpty(user.getName()))
			throw new ServiceException("姓名不能为空！");
		String uuid=UUIDUtils.newShortUUID().toString();
		user.setUid(uuid);
		SimpleHash sh=new SimpleHash("MD5", user.getPassword());
		user.setPassword(sh.toHex());
		int rows=userMapper.insert(user);
		return rows;
	}
	//用户登录
	@Override
	public int doLogin(User user) {
		if(user==null)
			throw new ServiceException("对象不能为空");
		if(StringUtils.isEmpty(user.getUsername()))
			throw new ServiceException("用户名不能为空");
		if(StringUtils.isEmpty(user.getPassword()))
			throw new ServiceException("密码不能为空");
		User u=userMapper.findByUsername(user.getUsername());
		if(u==null)
			throw new ServiceException("该用户不存在");
		SimpleHash sh=new SimpleHash("MD5", user.getPassword());
		if(sh.toHex()!=u.getPassword())
			throw new ServiceException("用户名或密码错误");
		return 1;
	}

}
