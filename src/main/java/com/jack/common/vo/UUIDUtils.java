package com.jack.common.vo;

import java.util.UUID;

public class UUIDUtils {
	public static String newShortUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
	}
}
