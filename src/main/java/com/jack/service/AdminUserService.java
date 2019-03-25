package com.jack.service;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.jack.entity.User;

public interface AdminUserService {
	/**分页查询页面信息*/
	PageInfo<User> findPageByUsername(Integer startPage, Integer pageSize, String username);
	/**导出用户信息查询*/
	List<User> findAllObjects();
	/**查询管理员用户信息*/
	User findByUsername(String username, String password);
}
