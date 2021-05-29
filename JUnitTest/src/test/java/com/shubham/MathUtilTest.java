package com.shubham;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

class MathUtilTest {

	MathUtil mathUtil;
	@BeforeEach
	void init() {
		mathUtil = new MathUtil();
	}
	
	@Test
	@Disabled
	void disabledTest() {
		System.out.println("Not yet implemented");
	}
	
	@Test
	@DisplayName(value = "Adding two numbers Test")
	@Tag(value = "Math Add")
	void addTest() {
		assertEquals(4, mathUtil.add(2, 2),"should return correct result");
	}
	
	@Test
	void subTest() {
		assumeTrue(false);
		assertEquals(1, mathUtil.sub(2, 1),"should return correct result");
	}
	
	@Nested
	class divide{
		@Test
		void divideByZeroTest() {
			assertThrows(ArithmeticException.class, () -> mathUtil.div(1, 0) ,"should return exception");
		}

		@Test
		void divTest() {
			assertEquals(2, mathUtil.div(4, 2),"should return correct result");
		}		
	}
	
	@Test
	@RepeatedTest(value = 2)
	void mulTest() {
		assertEquals(2, mathUtil.mul(2, 1),"should return correct result");
	}
	
	
	@Test
	@EnabledOnOs(value = OS.LINUX)
	void linuxTest() {
		System.out.println("Linux Test case");
	}
	
	@Test
//	@Timeout(unit = TimeUnit.NANOSECONDS,value = 100)
	void arrayTest() {
		int a[] = {1,2,3,4};
		int b[] = {4,3,2,1};
		for(int i=0;i<100000;i++) 
		Arrays.sort(b);
		Assertions.assertArrayEquals(a, b);
	}

}
