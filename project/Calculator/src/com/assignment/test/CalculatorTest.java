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

}
