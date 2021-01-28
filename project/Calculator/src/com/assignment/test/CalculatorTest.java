package com.assignment.test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.assignment.calculator.StringCalculator;

public class CalculatorTest {

	private static StringCalculator sc = new StringCalculator();

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testNull() throws Exception {
		int sum = CalculatorTest.sc.add("");
		assertEquals(0, sum);
	}

	@Test
	public void testAddition() throws Exception {
		int sum = CalculatorTest.sc.add("1,3,10");
		assertEquals(14, sum);
	}

	@Test
	public void testUnknownNumberInArgument() throws Exception {
		int sum = CalculatorTest.sc.add("1,3,10,0");
		assertEquals(0, sum);
	}

	@Test
	public void testLineChange() throws Exception {
		int sum = CalculatorTest.sc.add("1\n10,100");
		assertEquals(111, sum);
	}

	@Test
	public void testDelimiters() throws Exception {
		int sum = CalculatorTest.sc.add("//l\n3l6\n7");
		assertEquals(16, sum);
	}

	@Test
	public void testNegativeNumbers() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("negatives not allowed - -7");
		int sum = CalculatorTest.sc.add("//l\n3l6\n-7");
	}

}
