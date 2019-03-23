package com.test;

import org.junit.Test;

import com.jack.common.vo.UUIDUtils;

public class TestUUID {
	@Test
	public void testUUID() {
		String uuid = UUIDUtils.newShortUUID();
		System.out.println(uuid);
	}
}
