package model;

public class Grade {
	public static String getLetterGrade1(int marks) {
		String lg = "";
		
		if (marks >= 90) {
			lg = "A+";
		} else if (marks >= 80) {
			lg = "A";
		} else if (marks >= 75) {
			lg = "B+";
		} else if (marks >= 70) {
			lg = "B";
		} else if (marks >= 65) {
			lg = "C+";
		} else if (marks >= 60) {
			lg = "C";
		} else if (marks >= 55) {
			lg = "D+";
		} else if (marks >= 50) {
			lg = "D";
		} else {
			lg = "F";
		}
		
		return lg;
	}
	
	public static String getLetterGrade2(int marks) {
		String lg = "";
		
		if (90 <= marks && marks <= 100) {
			lg = "A+";
		}
		if (80 <= marks && marks < 90) {
			lg = "A";
		}
		if (75 <= marks && marks < 80) {
			lg = "B+";
		}
		if (70 <= marks && marks < 75) {
			lg = "B";
		}
		if (65 <= marks && marks < 70) {
			lg = "C+";
		}
		if (60 <= marks && marks < 65) {
			lg = "C";
		}
		if (55 <= marks && marks < 60) {
			lg = "D+";
		}
		if (50 <= marks && marks < 55) {
			lg = "D";
		} 
		if (0 <= marks && marks < 50) {
			lg = "F";
		}
//		else {
//			lg = "F";
//		}
		
		return lg;
	}	
}
