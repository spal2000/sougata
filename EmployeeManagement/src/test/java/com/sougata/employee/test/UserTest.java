package com.sougata.employee.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserTest {
	
	App a = new App();
	@Test
	void AppTest() {
		
		int expected = 20;
		
		int actual = a.add(12, 8);
		
		assertEquals(actual,expected);
	}
	
	}
