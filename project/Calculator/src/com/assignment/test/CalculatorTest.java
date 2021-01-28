package com.assignment.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.assignment.calculator.StringCalculator;

public class CalculatorTest {
	
	private static StringCalculator sc = new StringCalculator();
	
	@Test
	public void testNull(){
		int sum = CalculatorTest.sc.add("");
		assertEquals(0, sum);
	}
	
	@Test
	public void testAddition(){
		int sum = CalculatorTest.sc.add("1,3,10");
		assertEquals(14, sum);
	}
	
	@Test
	public void testUnknownNumberInArgument(){
		int sum = CalculatorTest.sc.add("1,3,10,0");
		assertEquals(0, sum);
	}
	
	@Test
	public void testLineChange(){
		int sum = CalculatorTest.sc.add("1\n10,100");
		assertEquals(111, sum);
	}
	
	@Test
	public void testDelimiters(){
		int sum = CalculatorTest.sc.add("//l\n3l6\n7");
		assertEquals(16, sum);
	}

}
