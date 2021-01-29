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
				String[] delimiterArr;
				if (numbers.substring(0, 2).equalsIgnoreCase("//")) {
					if (numbers.substring(2, 3).equalsIgnoreCase("[")) {
						int delimiterEndIndex = numbers.lastIndexOf(']');
						// assuming " " is not a delimiter
						delimiterArr = numbers.substring(3, delimiterEndIndex ).replace("][", " ").split(" ");
						numbers = numbers.substring(delimiterEndIndex + 2);
					} else {
						delimiterArr = Character.toString(numbers.charAt(2)).split("");
						numbers = numbers.substring(4);
					}
				} else {
					delimiterArr = delimiter.split("");
				}
				numbers = numbers.replaceAll("\n", delimiterArr[0]);
				String specialChars = "*+?^";
				String[] escapedDelimiterArr =new String[delimiterArr.length];
				for(int j=0; j< delimiterArr.length; j++){
					delimiter = delimiterArr[j];
					String escapedDelimiter = "";
					for (int k = 0; k < delimiter.length(); k++) {
						if (specialChars.contains(delimiter.substring(k, k + 1)))
							escapedDelimiter += delimiter.substring(k, k + 1);
						else
							escapedDelimiter += delimiter;
					}
					escapedDelimiterArr[j] = escapedDelimiter;
				}
				for(String replaceDelimiter : escapedDelimiterArr){
					numbers = numbers.replace(replaceDelimiter, ",");
				}
				String[] numArr = numbers.split(",");
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
