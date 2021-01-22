package console_apps;

import java.util.Scanner;

import model.Grade;

public class GradeApp1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a raw mark score (from 0 to 100):");
		int marks = input.nextInt();
		
		String lg = Grade.getLetterGrade1(marks);
		
		System.out.println("it is letter grade " + lg);
		
		input.close();
	}

}
