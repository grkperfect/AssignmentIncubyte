package com.assignment.calculator;

import java.util.Scanner;
import java.lang.Integer;

public class StringCalculator {

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int i = 0;
		try {
			while (i < 3) {
				if (i != 0)
					sb.append("\n");
				sb.append(scanner.nextLine());
				++i;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		StringCalculator sc = new StringCalculator();
		System.out.println("Sum: " + sc.add(sb.toString()));
	}

	public int add(String numbers) {
		int sum = 0;
		if (null == numbers || numbers.isEmpty()) {
			return 0;
		}
		if (numbers.length() > 0) {
			numbers = numbers.replace("\n", ",");
			String[] numArr = numbers.split(",");
			if (!(numArr.length > 3)) {
				for (String eachNum : numArr) {
					if(null != eachNum && !eachNum.isEmpty())
					sum = sum + Integer.parseInt(eachNum);
				}
			}

		}
		return sum;
	}

}
