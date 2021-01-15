package console_apps;

import java.util.Scanner;

/*
 * Test comment, Console App 
 * App prompts user for radius of 2 circles
 * App will output areas of the 2 circles
 */
public class CircleApp1 {

	public static void main(String[] args) {
		// System.in denotes the standard imput(ex. keyboard)
		Scanner input = new Scanner(System.in);

		// Start of application code
		/*
		 * Calculate the first circle
		 */
		System.out.println("Enter the radius of the 1st circle:"); // Prompt the user for the radius of the 1st circle
		double radius1 = input.nextDouble(); // Get the input of radius
		double area1 = 3.14 * radius1 * radius1; // Calculate the area of the circle, given the radius
		String area1s = String.format("%.2f", area1);
		System.out.println("Area of circle is: " + area1s);
		/*
		 * Calculate the second circle
		 */
		System.out.println("Enter the radius of the 2nd circle:"); // Prompt the user for the radius of the 1st circle
		double radius2 = input.nextDouble(); // Get the input of radius
		double area2 = 3.14 * radius2 * radius2; // Calculate the area of the circle, given the radius
		String area2s = String.format("%.2f", area2);
		System.out.println("Area of circle is: " + area2s);
		// End of application code
		input.close();
	}

}
