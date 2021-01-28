package com.assignment.calculator;

import java.util.Scanner;
import java.lang.Integer;

public class StringCalculator {

	
	public static void main(String args[]){
		
		Scanner scanner = new Scanner(System.in);
		String arg = scanner.nextLine();
		StringCalculator sc = new StringCalculator();
		System.out.println(sc.add(arg));
	}
	
	public int add(String numbers){
		int sum=0;
		if(null == numbers && "".equalsIgnoreCase(numbers)){
			return 0;
		}
		if(numbers.length() > 0){
			String[] numArr = numbers.split(",");
			for(String eachNum : numArr){
				sum = sum + Integer.parseInt(eachNum);
			}
		}
		return sum;
	}
	
}
