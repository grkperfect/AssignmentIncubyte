package com.assignment.test;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import com.assignment.calculator.StringCalculator;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalculatorTest {

	private static StringCalculator sc = new StringCalculator();

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testNull() throws Exception {
		int sum = sc.Add("");
		assertEquals(0, sum);
	}

	@Test
	public void testAddition() throws Exception {
		int sum = sc.Add("1,3,10");
		assertEquals(14, sum);
	}

	@Test
	public void testUnknownNumberInArgument() throws Exception {
		int sum = sc.Add("1,3,10,0");
		assertEquals(0, sum);
	}

	@Test
	public void testLineChange() throws Exception {
		int sum = sc.Add("1\n10,100");
		assertEquals(111, sum);
	}

	@Test
	public void testDelimiters() throws Exception {
		int sum = sc.Add("//l\n3l6\n7");
		assertEquals(16, sum);
	}

	@Test
	public void testNegativeNumbers() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("negatives not allowed - -7");
		int sum = sc.Add("//l\n3l6\n-7");
	}

	@Test
	public void testMultipleNegativeNumbers() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("negatives not allowed - -3,-6,-9");
		int sum = sc.Add("//l\n-3l-6\n-9");
	}

	@Test
	public void testAdditionCount() throws Exception {
		int addCount = sc.GetCalledCount();
		assertEquals(2, addCount); // will not work if order of execution of
									// test case is different
	}

	@Test
	public void testAddLessThan1001() throws Exception {
		int sum = sc.Add("1002\n10,100");
		assertEquals(110, sum);
	}

}
