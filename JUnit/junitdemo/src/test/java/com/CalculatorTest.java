package com;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@DisplayName("Testing Arithmetic Operations")
@TestInstance(Lifecycle.PER_CLASS)
class CalculatorTest {
	static Calculator c1;
	static boolean condition=false;
	@BeforeAll    	//@BeforeClass
	static void createCalculator() {
		c1 = new Calculator();
		System.out.println("--------STARTED---------");
	}
	
	@AfterAll		//@AfterClass
	static void removeCalculator() {
		c1=null;
		System.out.println("--------FINISHED---------");
	}
	@BeforeEach     //@Before
	void abc() {
		System.out.println("Before Each test case....");
	}
	@AfterEach		//@After
	void xyz() {
		System.out.println("After Each test case....");
	}
	@Test
	@DisplayName("Testing Dummy Operation")
	void test() {
		assertTrue(true);
		System.out.println("from test() method");
	}
	@Test
	@Disabled		//@Ignore
	@DisplayName("Testing Addition Operation")
	void testAdd() {
		assertEquals(30,c1.add(10, 20),()->"Sum result is not right");
		assertEquals(50,c1.add(30, 20),()->"Sum result is not right");
		assertEquals(-10,c1.add(10, -20),()->"Sum result is not right");
		System.out.println("from testAdd() method");
	}
	@Test
	@DisplayName("Testing Division Operation")
	void testDiv() {
		assertEquals(2,c1.div(10, 5),()->"Div result is not right");
		assertThrows(ArithmeticException.class,()->c1.div(90, 0),()->"Div result is not right");
		System.out.println("from testDiv() method");
	}
	@Test
	@Tag("Math")
	@DisplayName("Testing Multipy Operation")
	void testMul() {
		assertAll(
			()->assertEquals(50,c1.mul(10, 5),()->"Mul result is not right"),
			()->assertEquals(100,c1.mul(20, 5),()->"Mul result is not right"),
			()->assertEquals(60,c1.mul(10, 6),()->"Mul result is not right"),
			()->assertEquals(90,c1.mul(10, 9),()->"Mul result is not right"),
			()->assertEquals(30,c1.mul(30, 1),()->"Mul result is not right"),
			()->assertEquals(30,c1.mul(6, 5),()->"Mul result is not right")
		);
		System.out.println("from testMul() method");
	}
	@Test
	@DisplayName("Testing Mod Operation")
	void testMod() {
		assumeTrue(condition);
		assertAll(
			()->assertEquals(0,c1.mod(10, 5),()->"Mul result is not right"),
			()->assertEquals(2,c1.mod(22, 5),()->"Mul result is not right"),
			()->assertEquals(4,c1.mod(10, 6),()->"Mul result is not right"),
			()->assertEquals(1,c1.mod(10, 9),()->"Mul result is not right"),
			()->assertEquals(5,c1.mod(30, 25),()->"Mul result is not right"),
			()->assertEquals(1,c1.mod(6, 5),()->"Mul result is not right")
		);
		System.out.println("from testMod() method");
	}
	
}
