package com.test;

import java.util.List;

import org.junit.Test;

import com.github.pagehelper.PageInfo;
import com.jack.entity.User;
import com.jack.service.AdminUserService;

public class TestUser extends TestBase{
	@Test
	public void testUser() {
		AdminUserService user = ctx.getBean("adminUserServiceImpl", AdminUserService.class);
		PageInfo<User> pi = user.findPageByUsername(1, 5, "");
		List<User> list = pi.getList();
		for (User u : list) {
			System.out.println(u);
		}
		System.out.println(pi);
	}
}
