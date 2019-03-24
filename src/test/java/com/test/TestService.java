package com.test;

import org.junit.Test;

import com.jack.entity.User;
import com.jack.service.UserService;

public class TestService extends TestBase {
	@Test
	public void test() {
		UserService us=ctx.getBean(UserService.class);
		User user=new User();
		user.setName("zz");
		user.setUsername("111");
		user.setPassword("123456");
		us.insertObject(user);
	}
}
