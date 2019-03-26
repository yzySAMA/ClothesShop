package com.test;

import java.io.File;

import org.junit.Test;

public class TestFile extends TestBase{
	@Test
	public void testFile() {
		String s = System.getProperty("webapp.root");
		System.out.println(s);
	}
}
