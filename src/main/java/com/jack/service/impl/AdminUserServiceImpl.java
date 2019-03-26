package com.jack.service.impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.jack.common.vo.JsonResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jack.common.exception.ServiceException;
import com.jack.dao.UserMapper;
import com.jack.entity.User;
import com.jack.entity.UserExample;
import com.jack.entity.UserExample.Criteria;
import com.jack.service.AdminUserService;


@Service
public class AdminUserServiceImpl implements AdminUserService{
	@Autowired
	private UserMapper userMapper;
	
	/**分页查询页面信息*/
	@Override
	public PageInfo<User> findPageByUsername(Integer startPage, Integer pageSize, String username) {
		// 分页查询
		PageHelper.startPage(startPage, pageSize);
		UserExample example = new UserExample();
		// 创建模糊查询
		if(!StringUtils.isEmpty(username)) {
			example.createCriteria().andUsernameLike("%"+username+"%");
		}
		List<User> list = userMapper.selectByExample(example);
		
		if (list == null || list.size() == 0) {
			throw new ServiceException("没有查询到数据");
		}
		PageInfo<User> pi = new PageInfo<>(list);
		return pi;
	}
	/**
	 * 用户信息查询用于导出到Excel
	 */
	@Override
	public List<User> findAllObjects() {
		List<User> list = userMapper.findAllObjects();
		return list;
	}
}
