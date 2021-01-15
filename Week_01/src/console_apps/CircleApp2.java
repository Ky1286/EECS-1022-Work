package console_apps;
import java.util.Scanner;

import model.Circle;

/*
 * Version 2, Console App 
 * App prompts user for radius of 2 circles
 * App will output areas of the 2 circles
 * Edit: Improved by adding method
 */
public class CircleApp2 {

	public static void main(String[] args) {
		//System.in denotes the standard imput(ex. keyboard)
		Scanner input = new Scanner(System.in); 
		
		//Start of application code
		/*
		 * Calculate the first circle
		 */
		System.out.println("Enter the radius of the 1st circle:"); //Prompt the user for the radius of the 1st circle
		double radius1 = input.nextDouble(); //Get the input of radius
		
		//Edit: Cleaned up the lin by utilizing a method call instead
		double area1 = Circle.getArea(radius1);
		
		String area1s = String.format("%.2f", area1); 
		System.out.println("Area of circle is: " + area1s);		
		/*
		 * Calculate the second circle
		 */
		System.out.println("Enter the radius of the 2nd circle:"); //Prompt the user for the radius of the 1st circle
		double radius2 = input.nextDouble(); //Get the input of radius
		
		//Edit: Cleaned up the lien by utilizing a method call instead
		double area2 = Circle.getArea(radius2);
		
		String area2s = String.format("%.2f", area2); 
		System.out.println("Area of circle is: " + area2s);
		//End of application code
		input.close();
	}

}
