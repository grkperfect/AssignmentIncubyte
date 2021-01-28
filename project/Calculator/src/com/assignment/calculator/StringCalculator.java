package com.assignment.calculator;

import java.util.Scanner;

public class StringCalculator {

	
	public static void main(String args[]){
		
		Scanner scanner = new Scanner(System.in);
		String arg = scanner.nextLine();
		StringCalculator sc = new StringCalculator();
		System.out.println(sc.add(arg));
	}
	
	public int add(String numbers){
		int sum=0;
		if("".equalsIgnoreCase(numbers)){
			return 0;
		}
		return sum;
	}
	
}
