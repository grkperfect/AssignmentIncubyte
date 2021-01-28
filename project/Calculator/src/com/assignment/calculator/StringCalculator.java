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
		try {
			System.out.println("Sum: " + sc.add(sb.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int add(String numbers) throws Exception {
		int sum = 0;
		boolean showResultFlag = false;
		if (null == numbers || numbers.isEmpty()) {
			return 0;
		}
		if (numbers.length() > 0) {
			try {
				String delimiter = ",";
				if (numbers.substring(0, 2).equalsIgnoreCase("//")) {
					delimiter = Character.toString(numbers.charAt(2));
					numbers = numbers.substring(4);
				}
				numbers = numbers.replaceAll("\n", delimiter);
				String[] numArr = numbers.split(delimiter);
				if (!(numArr.length > 3)) {
					for (String eachNum : numArr) {
						if (null != eachNum && !eachNum.isEmpty()) {
							int eachNumInteger = Integer.parseInt(eachNum);
							if (eachNumInteger < 0) {
								showResultFlag = true;
								throw new Exception("negatives not allowed - " + eachNum);
							}
							sum = sum + eachNumInteger;
						}
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw new Exception(e.getMessage());
			}
		}
		if (showResultFlag)
			return 0;
		else
			return sum;
	}

}
