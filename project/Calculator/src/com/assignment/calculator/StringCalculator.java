package com.assignment.calculator;

import java.util.Scanner;
import java.lang.Integer;

public class StringCalculator {

	private static int addCounter = 0;

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int i = 0;
		try {
			while (i < 2) {
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
			System.out.println("Sum: " + sc.Add(sb.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int Add(String numbers) throws Exception {
		++addCounter;
		int sum = 0;
		boolean showResultFlag = false;
		if (null == numbers || numbers.isEmpty()) {
			return 0;
		}
		if (numbers.length() > 0) {
			try {
				String delimiter = ",";
				if (numbers.substring(0, 2).equalsIgnoreCase("//")) {
					if (numbers.substring(2, 3).equalsIgnoreCase("[")) {
						int delimiterEndIndex = numbers.lastIndexOf(']');
						delimiter = numbers.substring(3, delimiterEndIndex);
						numbers = numbers.substring(delimiterEndIndex + 2);
					} else {
						delimiter = Character.toString(numbers.charAt(2));
						numbers = numbers.substring(4);
					}
				}
				numbers = numbers.replaceAll("\n", delimiter);
				String specialChars = "*+?^";
				String escapedDelimiter = "";
				for (int k = 0; k < delimiter.length(); k++) {
					if (specialChars.contains(delimiter.substring(k, k + 1)))
						escapedDelimiter += "\\" + delimiter.substring(k, k + 1);
					else
						escapedDelimiter += delimiter;
				}
				String[] numArr = numbers.split(escapedDelimiter);
				if (!(numArr.length > 3)) {
					String negativeNumbers = "";
					for (String eachNum : numArr) {
						if (null != eachNum && !eachNum.isEmpty()) {
							int eachNumInteger = Integer.parseInt(eachNum);
							if (eachNumInteger < 0) {
								negativeNumbers += eachNum + ",";
								showResultFlag = true;
							} else {
								if (eachNumInteger <= 1000)
									sum = sum + eachNumInteger;
							}
						}
					}
					if (negativeNumbers.length() > 0) {
						negativeNumbers = negativeNumbers.substring(0, negativeNumbers.length() - 1);
						throw new Exception("negatives not allowed - " + String.join(",", negativeNumbers));
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

	public int GetCalledCount() {
		return addCounter;
	}

}
