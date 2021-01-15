package model;

public class Circle {
	//Method to get the area of a circle, given a radius
	public static double getArea(double x) {
		double area = 0.0;
		//Correct
		area = 3.14 * x * x;
//		//Incorrect
//		area = 2 * 3.14 * x;
		return area;
	}
}
