package model;

public class Utilities {
	/*
	 * 	Requirements:
	 * 	- It is strictly forbidden for you to use: 
	 * 		+ Any Java library method (e.g., Arrays.sort)
	 * 		  (That is, there must not be an import statement in the beginning of this class.)
	 * 		+ arrays
	 * 	- You will receive an immediate zero for this task if the requirement is violated. 
	 * 
	 * Only write lines of code within the methods given to you. Do not add any new
	 * helper methods. Do not declare any variables OUTSIDE the given methods. You
	 * can only declare local variables within each method.
	 * 
	 * Your submission will only be graded against: - JUnit tests given to you in
	 * TestUtilities - additional JUnit tests (therefore it is important that you
	 * test your own methods by either the console application class App or your own
	 * JUnit tests)
	 */

	/*	Task 1.
	 * 	
	 * 	Input Parameters:
	 *	- `weightUnit`	: either 'p' (for pound) or 'k' (for kilogram)
	 *	- `w`			: the weight value
	 *	- `heightUnit`	: either 'f' (for foot) or 'i' (for inch)
	 *	- `h`			: the height value
	 *
	 *	Error conditions (in order of priority):
	 *	1. When the `weightUnit` is neither 'p' nor 'k' (case sensitive).
	 *	2. When the `heightUnit` is neither 'f' nor 'i' (case sensitive).
	 *	3. When not both weight value and height value are positive.
	 *	If multiple error conditions hold, return a message related to the error with the highest priority.
	 *	e.g., invoking getBMIReport('q', -154.3, 'I', -66.92) has all inputs invalid,
	 *			but only an error message about weight unit is returned.
	 *
	 *  What to return?
	 *  - Return an error message if there is any error.
	 *  - Otherwise, calculate the Body Mass Index (BMI) by: weight (in kilogram) divided by the square of height (in meters).
	 *  	+ Use the following conversion rates (when needed):
	 *  		1 inch is 0.0254 meter 			(use it when `heightUnit` is 'i')
	 *  		1 foot is 0.3048 meter
	 *  		1 pound is 0.453592 kilogram
	 *  	+ The calculation result must be formatted with 2 digits after the decimal:
	 *  		Use String.format("%.2f", someNumber)
	 *  	+ Also, include an interpretation message (case sensitive) according to the following scheme:
	 *  		BMI < 18.5 			means "Underweight"
	 * 			18.5 <= BMI < 25.0 	means "Normal"
	 * 			25.0 <= BMI < 30.0 	means "Overweight"
	 * 			30.0 <= BMI 		means "Obese"
	 * 
	 * See the JUnit tests related to this method for the precise format of the string return value.
	 */
	public static String getBMIReport(char weightUnit, double w, char heightUnit, double h) {
		String result = "";

		/*
		 * Your task is to implement this method, so that running TestUtilities.java
		 * will pass all JUnit tests.
		 * 
		 * Recall from Week 1's tutorial videos: 1. No System.out.println statements
		 * should appear here. Instead, an explicit, final `return` statement is placed
		 * for you. 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 * Instead, refer to the input parameters of this method. 3. Do not re-assign
		 * any of the parameter/input variables.
		 */

		// Your implementation of this method starts here.
		
		//I converted the units to all possible useable units, for conveince.
		double inchesToMeter = h * 0.0254; //regardless, the of the unit, we have to convert to meter anyways
		double footToMeter = h * 0.3048;
		double poundToKilo = w * 0.453592;
		double kilo = w; //if unit is 'k', conversition doesn't matter, and if it's 'p' we don't use this anyways
		
		double bmi = 0;
		
		if (weightUnit != 'p' && weightUnit != 'k') {
			result = "Error: " + weightUnit +" is not a valid weight unit";
		} else if (heightUnit != 'f' && heightUnit != 'i') {
			result = "Error: " + heightUnit + " is not a valid height unit";
		} else if (w < 0 || h < 0) {
			result = "Error: both weight and height must be positive";
		} else {
			if (weightUnit == 'p') {
				if (heightUnit == 'f') {
					bmi = poundToKilo/(footToMeter * footToMeter);
				} else if (heightUnit == 'i') {
					bmi = poundToKilo/(inchesToMeter * inchesToMeter);
				}
			} else if (weightUnit == 'k') {
				if (heightUnit == 'f') {
					bmi = kilo/(footToMeter * footToMeter);
				} else if (heightUnit == 'i') {
					bmi = kilo/(inchesToMeter * inchesToMeter);
				}
			}
			if (bmi < 18.5) {
				result = "BMI is: " + String.format("%.2f", bmi) + " (Underweight)";
			} else if (bmi >= 18.5 && bmi < 25) {
				result = "BMI is: " + String.format("%.2f", bmi) + " (Normal)";
			} else if (bmi >= 25 && bmi < 30) {
				result = "BMI is: " + String.format("%.2f", bmi) + " (Overweight)";
			} else if (bmi >= 30) {
				result = "BMI is: " + String.format("%.2f", bmi) + " (Obese)";
			}
		}
		

		// Do not modify this return statement.
		return result;
	}
	
	
	
	/*
	 * Task 2.
	 * 
	 * Input Parameters: 
	 * - `coffeeType`	: either 'L' (for light type), 'R' (for regular type) or 'D' (for dark type)
	 * - `cupSize`		: either 'S' (for small size), 'M' (for medium size) or 'L' (for large size)
	 * - `numberofCup`	: integer represent number of cups ordered
	 * 
	 * Assumptions:
	 * 	- the numberofCups is positive value greater than zero.
	 *	- `coffeeType` and `cupSize` characters are valid (no error checking is needed).
	 *
	 * What to return? - First you need to determine the cost of single cup of coffee in dollars according to the following facts
	 * If coffee type is light coffee then the initial cost of single cup of any size is 0.75 dollars.
	 * If coffee type is regular coffee then the initial cost of single cup of any size is 0.95 dollars.
	 * If coffee type is dark coffee then the initial cost of single cup of any size is 1.20 dollars.
	 * 
	 * Now, consider the size 
	 * if the cup size is small then add 0.50 dollars. 
	 * if the cup size is medium then add 0.75 dollars.
	 * if the cup size is large then add 0.95 dollars.
	 * 
	 * Do not forget to consider the number of cup to determine the final cost of coffee order
	 * 
	 * Note that The calculated cost of coffee order must be
	 * formatted with 2 digits after the decimal. 
	 * 
	 * If you need you can use String.format("%.2f", coffeeValue) 
	 * to form (or create)  the string output.
	 * The output string should include  message with case sensitive. For example:
	 * 
	 * "You ordered 5 cups of type light and size small, then your cost is 6.25$" 
	 * "You ordered 1 cup of type light and size small, then your cost is 1.25$" 
	 * "You ordered 7 cups of type dark and size large, then your cost is 15.05$" 
	 * 
	 *Note: we use cup  when the order is for single cup and 
	 *  we use cups  when the order is for more than one cup
	 *  
	 * See the JUnit tests related to this method for the precise format of the
	 * string return value.
	 */
	
	public static String getCoffeeCost(char coffeeType, char cupSize, int numberofCup) {
		String result = "";
		/*
		 * Your task is to implement this method, so that running TestUtilities.java
		 * will pass all JUnit tests.
		 * 
		 * Recall from Week 1's tutorial videos: 1. No System.out.println statements
		 * should appear here. Instead, an explicit, final `return` statement is placed
		 * for you. 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 * Instead, refer to the input parameters of this method. 3. Do not re-assign
		 * any of the parameter/input variables.
		 */
		double cost = 0;
		if (coffeeType == 'L') {
			if (cupSize == 'S') {
				cost = (0.75 + 0.5) * numberofCup;
				if (numberofCup == 1) {
					result = "You ordered "+ numberofCup +" cup of type light and size small, then your cost is " + String.format("%.2f", cost) +"$";	
				} else {
					result = "You ordered "+ numberofCup +" cups of type light and size small, then your cost is " + String.format("%.2f", cost) +"$";	
				}
				
			} else if (cupSize == 'M') {
				cost = (0.75 + 0.75) * numberofCup;
				if (numberofCup == 1) {
					result = "You ordered "+ numberofCup +" cup of type light and size medium, then your cost is " + String.format("%.2f", cost) +"$";	
				} else {
					result = "You ordered "+ numberofCup +" cups of type light and size medium, then your cost is " + String.format("%.2f", cost) +"$";
				}
			} else if (cupSize == 'L') {
				cost = (0.75 + 0.95) * numberofCup;
				if (numberofCup == 1) {
					result = "You ordered "+ numberofCup +" cup of type light and size large, then your cost is " + String.format("%.2f", cost) +"$";
				} else {
					result = "You ordered "+ numberofCup +" cups of type light and size large, then your cost is " + String.format("%.2f", cost) +"$";
				}
			}
		} else if (coffeeType == 'R') {
			if (cupSize == 'S') {
				cost = (0.95 + 0.5) * numberofCup;
				if (numberofCup == 1) {
					result = "You ordered "+ numberofCup +" cup of type regular and size small, then your cost is " + String.format("%.2f", cost) +"$";
				} else {
					result = "You ordered "+ numberofCup +" cups of type regular and size small, then your cost is " + String.format("%.2f", cost) +"$";
				}
			} else if (cupSize == 'M') {
				cost = (0.95 + 0.75) * numberofCup;
				if (numberofCup == 1) {
					result = "You ordered "+ numberofCup +" cup of type regular and size medium, then your cost is " + String.format("%.2f", cost) +"$";
				} else {
					result = "You ordered "+ numberofCup +" cups of type regular and size medium, then your cost is " + String.format("%.2f", cost) +"$";
				}
			} else if (cupSize == 'L') {
				cost = (0.95 + 0.95) * numberofCup;
				if (numberofCup == 1) {
					result = "You ordered "+ numberofCup +" cup of type regular and size large, then your cost is " + String.format("%.2f", cost) +"$";
				} else {
					result = "You ordered "+ numberofCup +" cups of type regular and size large, then your cost is " + String.format("%.2f", cost) +"$";
				}
			}
		} else if (coffeeType == 'D') {
			if (cupSize == 'S') {
				cost = (1.20 + 0.5) * numberofCup;
				if (numberofCup == 1) {
					result = "You ordered "+ numberofCup +" cup of type dark and size small, then your cost is " + String.format("%.2f", cost) +"$";
				} else {
					result = "You ordered "+ numberofCup +" cups of type dark and size small, then your cost is " + String.format("%.2f", cost) +"$";
				}
			} else if (cupSize == 'M') {
				cost = (1.20 + 0.75) * numberofCup;
				if (numberofCup == 1) {
					result = "You ordered "+ numberofCup +" cup of type dark and size medium, then your cost is " + String.format("%.2f", cost) +"$";
				} else {
					result = "You ordered "+ numberofCup +" cups of type dark and size medium, then your cost is " + String.format("%.2f", cost) +"$";
				}
			} else if (cupSize == 'L') {
				cost = (1.20 + 0.95) * numberofCup;
				if (numberofCup == 1) {
					result = "You ordered "+ numberofCup +" cup of type dark and size large, then your cost is " + String.format("%.2f", cost) +"$";
				} else {
					result = "You ordered "+ numberofCup +" cups of type dark and size large, then your cost is " + String.format("%.2f", cost) +"$";
				}
			}
		}
		
		
		// Do not modify this return statement.
		return result;
	}

	/*
	 * Task 3.
	 * 
	 * Input Parameters: 
	 * - `pizzaType`		: either 'C' (for CHEESE type), 'V' (for VEGGIE type) or 'P' (for PEPPERONI type)
	 * - `pizzaSize`		: either 'S' (for small size), 'M' (for medium size) or 'L' (for large size)
	 * - `numberofPizza`	: integer represent number of pizza ordered
	 * 
	 * In this method, assume the numberofPizza is positive value greater than zero.
	 *
	 * What to return? - First you need to determine the preparation time  
	 * of single pizza in term of minutes and seconds  according to the following facts
	 * If pizza type is CHEESE  then the initial preparation time of single pizza of any size is 75 seconds.
	 * If pizza type is VEGGIE  then the initial preparation time of single pizza of any size is 125 seconds.
	 * If pizza type is PEPPERONI  then the initial preparation time of single pizza of any size is 365 seconds.
	 * 
	 * Now, consider the size 
	 * if the pizza size is small then add 45 seconds. 
	 * if the pizza size is medium then add 65 seconds.
	 * if the pizza size is large then add 75 seconds.
	 * 
	 * Do not forget to consider the number of pizza to determine the final preparation time of pizza order
	 * 
	 * The output string should include  message with case sensitive. For example:
	 * 
	 * "You ordered 5 pizza of type CHEESE and size small, then your time is 10 minutes 0 seconds" 
	 * "You ordered 1 pizza of type VEGGIE and size small, then your time is 3 minutes 10 seconds" 
	 * "You ordered 7 pizza of type PEPPERONI and size large, then your time is 51 minutes 20 seconds" 
	 *  
	 * See the JUnit tests related to this method for the precise format of the
	 * string return value.
	 */
	
	public static String getPizzaTime(char pizzaType, char pizzaSize, int numberofPizza) {
		String result = "";
		/*
		 * Your task is to implement this method, so that running TestUtilities.java
		 * will pass all JUnit tests.
		 * 
		 * Recall from Week 1's tutorial videos: 1. No System.out.println statements
		 * should appear here. Instead, an explicit, final `return` statement is placed
		 * for you. 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 * Instead, refer to the input parameters of this method. 3. Do not re-assign
		 * any of the parameter/input variables.
		 */
		int time = 0;
		int mins = 0;
		int secs = 0;
		if (pizzaType == 'C') {
			if (pizzaSize == 'S') {
				time = (75 + 45) * numberofPizza;
				mins = time/60;
				secs = time % 60;
				result = "You ordered "+ numberofPizza +" pizza of type CHEESE and size small, then your time is "+ mins +" minutes "+ secs +" seconds";
			} else if (pizzaSize == 'M') {
				time = (75 + 65) * numberofPizza;
				mins = time/60;
				secs = time % 60;
				result = "You ordered "+ numberofPizza +" pizza of type CHEESE and size medium, then your time is "+ mins +" minutes "+ secs +" seconds";
			} else if (pizzaSize == 'L') {
				time = (75 + 75) * numberofPizza;
				mins = time/60;
				secs = time % 60;
				result = "You ordered "+ numberofPizza +" pizza of type CHEESE and size large, then your time is "+ mins +" minutes "+ secs +" seconds";
			}
		} else if (pizzaType == 'V') {
			if (pizzaSize == 'S') {
				time = (125 + 45) * numberofPizza;
				mins = time/60;
				secs = time % 60;
				result = "You ordered "+ numberofPizza +" pizza of type VEGGIE and size small, then your time is "+ mins +" minutes "+ secs +" seconds";
			} else if (pizzaSize == 'M') {
				time = (125 + 65) * numberofPizza;
				mins = time/60;
				secs = time % 60;
				result = "You ordered "+ numberofPizza +" pizza of type VEGGIE and size medium, then your time is "+ mins +" minutes "+ secs +" seconds";
			} else if (pizzaSize == 'L') {
				time = (125 + 75) * numberofPizza;
				mins = time/60;
				secs = time % 60;
				result = "You ordered "+ numberofPizza +" pizza of type VEGGIE and size large, then your time is "+ mins +" minutes "+ secs +" seconds";
			}
		} else if (pizzaType == 'P') {
			if (pizzaSize == 'S') {
				time = (365 + 45) * numberofPizza;
				mins = time/60;
				secs = time % 60;
				result = "You ordered "+ numberofPizza +" pizza of type PEPPERONI and size small, then your time is "+ mins +" minutes "+ secs +" seconds";
			} else if (pizzaSize == 'M') {
				time = (365 + 65) * numberofPizza;
				mins = time/60;
				secs = time % 60;
				result = "You ordered "+ numberofPizza +" pizza of type PEPPERONI and size medium, then your time is "+ mins +" minutes "+ secs +" seconds";
			} else if (pizzaSize == 'L') {
				time = (365 + 75) * numberofPizza;
				mins = time/60;
				secs = time % 60;
				result = "You ordered "+ numberofPizza +" pizza of type PEPPERONI and size large, then your time is "+ mins +" minutes "+ secs +" seconds";
			}
		}
		
		
		// Do not modify this return statement.
		return result;
	}
	
}
