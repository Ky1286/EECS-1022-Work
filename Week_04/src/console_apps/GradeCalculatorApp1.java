package console_apps;

import java.util.Scanner;

public class GradeCalculatorApp1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your name:");
		String name = input.nextLine();
		System.out.println(name + ", what's the weight of your Assignment 1?");
		System.out.println(name + ", what's the marks of your Assignment 1 (out of 100)?");
		
		
		input.close();
	}

}
