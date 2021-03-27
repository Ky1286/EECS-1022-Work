package junit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Utilities;

public class TestUtilities {
	
	/*
	 * Tests related to getMultiplesOf3 
	 */
	@Test
	public void test_getMultiplesOf3_01() {
		int[] input = {1, 2, 3, 4, 5, 6};
		int[] result = Utilities.getMultiplesOf3(input);
		int[] expected = {3, 6};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void test_getMultiplesOf3_02() {
		int[] input = {1, 2, 4, 5, 7, 8};
		int[] result = Utilities.getMultiplesOf3(input);
		int[] expected = {};
		assertArrayEquals(expected, result);
	}
	
	/*
	 * Tests related to getFilteredSeq
	 */
	@Test
	public void test_getFilteredSeq_01() {
		int[] input = {4, 2, 3, 1, 4, 2, 4, 3, 4, 3};
		int[] result = Utilities.getFilteredSeq(input, 1);
		int[] expected = {4, 2, 3, 4, 2, 4, 3, 4, 3};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void test_getFilteredSeq_02() {
		int[] input = {4, 2, 3, 1, 4, 2, 4, 3, 4, 3};
		int[] result = Utilities.getFilteredSeq(input, 2);
		int[] expected = {4, 3, 1, 4, 4, 3, 4, 3};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void test_getFilteredSeq_03() {
		int[] input = {4, 2, 3, 1, 4, 2, 4, 3, 4, 3};
		int[] result = Utilities.getFilteredSeq(input, 3);
		int[] expected = {4, 2, 1, 4, 2, 4, 4};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void test_getFilteredSeq_04() {
		int[] input = {4, 2, 3, 1, 4, 2, 4, 3, 4, 3};
		int[] result = Utilities.getFilteredSeq(input, 4);
		int[] expected = {2, 3, 1, 2, 3, 3};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void test_getFilteredSeq_05() {
		int[] input = {4, 2, 3, 1, 4, 2, 4, 3, 4, 3};
		int[] result = Utilities.getFilteredSeq(input, 5);
		int[] expected = {4, 2, 3, 1, 4, 2, 4, 3, 4, 3};
		assertArrayEquals(expected, result);
	}
	
	/*
	 * Tests related to getAllPrefixes
	 */
	@Test
	public void test_getAllPrefixes_01() {
		int[] input = {3};
		String[] result = Utilities.getAllPrefixes(input);
		String[] expected = {"[3]"};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void test_getAllPrefixes_02() {
		int[] input = {3, 1};
		String[] result = Utilities.getAllPrefixes(input);
		String[] expected = {"[3]", "[3, 1]"};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void test_getAllPrefixes_03() {
		int[] input = {3, 1, 4};
		String[] result = Utilities.getAllPrefixes(input);
		String[] expected = {"[3]", "[3, 1]", "[3, 1, 4]"};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void test_getAllPrefixes_04() {
		int[] input = {3, 1, 4, 5};
		String[] result = Utilities.getAllPrefixes(input);
		String[] expected = {"[3]", "[3, 1]", "[3, 1, 4]", "[3, 1, 4, 5]"};
		assertArrayEquals(expected, result);
	}
	
	/*
	 * Tests related to getGroupedNumbers 
	 */
	@Test
	public void test_getGroupedNumbers_00() {
		int[] input = {};
		int[] result = Utilities.getGroupedNumbers(input);
		int[] expected = {};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void test_getGroupedNumbers_01() {
		int[] input = {1, 2, 3, 4, 5, 6};
		int[] result = Utilities.getGroupedNumbers(input);
		int[] expected = {3, 6, 1, 4, 2, 5};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void test_getGroupedNumbers_02() {
		int[] input = {1, 2, 4, 5};
		int[] result = Utilities.getGroupedNumbers(input);
		int[] expected = {1, 4, 2, 5};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void test_getGroupedNumbers_03() {
		int[] input = {2, 3, 5, 6};
		int[] result = Utilities.getGroupedNumbers(input);
		int[] expected = {3, 6, 2, 5};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void test_getGroupedNumbers_04() {
		int[] input = {1, 3, 4, 6};
		int[] result = Utilities.getGroupedNumbers(input);
		int[] expected = {3, 6, 1, 4};
		assertArrayEquals(expected, result);
	}
}
