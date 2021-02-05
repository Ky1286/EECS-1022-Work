package junit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Utilities;

public class TestUtilities {
	
	/*
	 * Tests related to getBMIReport
	 */
	@Test
	public void test_getBMIReport_01() {
		String result = Utilities.getBMIReport('k', 40, 'f', 5.57);
		assertEquals("BMI is: 13.88 (Underweight)", result);
	}
	
	@Test
	public void test_getBMIReport_02() {
		String result = Utilities.getBMIReport('k', 70, 'i', 66.92);
		assertEquals("BMI is: 24.23 (Normal)", result);
	}
	
	@Test
	public void test_getBMIReport_03() {
		String result = Utilities.getBMIReport('p', 154.3, 'f', 5.13);
		assertEquals("BMI is: 28.63 (Overweight)", result);
	}
	
	@Test
	public void test_getBMIReport_04() {
		String result = Utilities.getBMIReport('p', 167.3, 'i', 60.92);
		assertEquals("BMI is: 31.69 (Obese)", result);
	}
	
	@Test
	public void test_getBMIReport_05a() {
		String result = Utilities.getBMIReport('q', -154.3, 'I', -66.92);
		assertEquals("Error: q is not a valid weight unit", result);
	}
	
	@Test
	public void test_getBMIReport_05b() {
		String result = Utilities.getBMIReport('p', -154.3, 'I', -66.92);
		assertEquals("Error: I is not a valid height unit", result);
	}
	
	@Test
	public void test_getBMIReport_05c() {
		String result = Utilities.getBMIReport('p', 154.3, 'i', -66.92);
		assertEquals("Error: both weight and height must be positive", result);
	} 
	
	
	
	
	@Test
	public void test_getCoffeeCost_01() {
		String result = Utilities.getCoffeeCost('L','S',5);
		assertEquals("You ordered 5 cups of type light and size small, then your cost is 6.25$", result);
	}
	
	@Test
	public void test_getCoffeeCost_02() {
		String result = Utilities.getCoffeeCost('L','L',1);
		assertEquals("You ordered 1 cup of type light and size large, then your cost is 1.70$", result);
	}
	
	@Test
	public void test_getCoffeeCost_03() {
		String result = Utilities.getCoffeeCost('D','M',2);
		assertEquals("You ordered 2 cups of type dark and size medium, then your cost is 3.90$", result);
	}
	@Test
	public void test_getCoffeeCost_04() {
		String result = Utilities.getCoffeeCost('L','L',15);
		assertEquals("You ordered 15 cups of type light and size large, then your cost is 25.50$", result);
	}
	
	@Test
	public void test_getCoffeeCost_05() {
		String result = Utilities.getCoffeeCost('R','S',1);
		assertEquals("You ordered 1 cup of type regular and size small, then your cost is 1.45$", result);
	}
	
	@Test
	public void test_getCoffeeCost_06() {
		String result = Utilities.getCoffeeCost('D','S',5);
		assertEquals("You ordered 5 cups of type dark and size small, then your cost is 8.50$", result);
	}
	
	@Test
	public void test_getPizzaTime_01() {
		String result = Utilities.getPizzaTime('C','S',1);
		assertEquals("You ordered 1 pizza of type CHEESE and size small, then your time is 2 minutes 0 seconds", result);
	}
	@Test
	public void test_getPizzaTime_02() {
		String result = Utilities.getPizzaTime('V','M',10);
		assertEquals("You ordered 10 pizza of type VEGGIE and size medium, then your time is 31 minutes 40 seconds", result);
	}
	@Test
	public void test_getPizzaTime_03() {
		String result = Utilities.getPizzaTime('P','L',7);
		assertEquals("You ordered 7 pizza of type PEPPERONI and size large, then your time is 51 minutes 20 seconds", result);
	}
	
	@Test
	public void test_getPizzaTime_04() {
		String result = Utilities.getPizzaTime('C','S',1);
		assertEquals("You ordered 1 pizza of type CHEESE and size small, then your time is 2 minutes 0 seconds", result);
	}
	@Test
	public void test_getPizzaTime_05() {
		String result = Utilities.getPizzaTime('V','S',10);
		assertEquals("You ordered 10 pizza of type VEGGIE and size small, then your time is 28 minutes 20 seconds", result);
	}
	@Test
	public void test_getCoffeeTime_06() {
		String result = Utilities.getPizzaTime('P','L',17);
		assertEquals("You ordered 17 pizza of type PEPPERONI and size large, then your time is 124 minutes 40 seconds", result);
	}
	
	
}
