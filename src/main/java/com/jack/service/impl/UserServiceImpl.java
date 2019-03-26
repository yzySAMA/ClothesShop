package com.jack.service.impl;


import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.jack.common.exception.ServiceException;
import com.jack.common.vo.UUIDUtils;
import com.jack.dao.ShopcartMapper;
import com.jack.dao.UserMapper;
import com.jack.entity.Shopcart;
import com.jack.entity.User;
import com.jack.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ShopcartMapper shopCartMapper; 
	/**用户注册*/
	@Override
	public int insertObject(User user) {
		if(user==null)
			throw new ServiceException("用户不能为空!");
		if(StringUtils.isEmpty(user.getUsername())||StringUtils.isEmpty(user.getPassword()))
			throw new ServiceException("用户名和密码不能为空!");
		if(userMapper.findByUsername(user.getUsername())!=null)
			throw new ServiceException("该用户名已存在");
		if(StringUtils.isEmpty(user.getName()))
			throw new ServiceException("姓名不能为空!");
		if(StringUtils.isEmpty(user.getTelephone()))
			throw new ServiceException("联系方式不能为空!");
		if(StringUtils.isEmpty(user.getEmail()))
			throw new ServiceException("邮箱不能为空!");
		String uuid=UUIDUtils.newShortUUID().toString();
		user.setUid(uuid);
		SimpleHash sh=new SimpleHash("MD5", user.getPassword());
		user.setPassword(sh.toHex());
		int rows=userMapper.insert(user);
		if(rows==0)
			throw new ServiceException("注册失败");
		//为用户创建购物车
		Shopcart shopCart=new Shopcart();
		shopCart.setUid(uuid);
		shopCart.setScid(UUIDUtils.newShortUUID().toString());
		shopCartMapper.insert(shopCart);
		return rows;
	}
	/**更新用户信息*/
	@Override
	public int doUpdateUser(User user) {
		if(user==null)
			throw new ServiceException("用户不能为空!");
		if(StringUtils.isEmpty(user.getName()))
			throw new ServiceException("姓名不能为空!");
		if(StringUtils.isEmpty(user.getEmail()))
			throw new ServiceException("邮箱不能为空");
		if(StringUtils.isEmpty(user.getTelephone()))
			throw new ServiceException("联系方式不能为空");
			int rows= userMapper.doUpdateUser(user);
			if(rows==0)
				throw new ServiceException("保存失败");
		return rows;
	}

}
