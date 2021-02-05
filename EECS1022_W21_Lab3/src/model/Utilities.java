package model;

public class Utilities {
	/*
	 * Input parameters:
	 * 	- `lower` is the lower bound
	 *  - `upper` is the upper bound
	 *  
	 * Use of arrays or any Java library class (e.g., ArrayList) is strictly forbidden.
	 * Violation of this will result in a 50% penalty on your marks.
	 * Try to solve this problem using loops only.   
	 *  
	 * Refer to you lab instructions for what the method should return. 
	 */
	public static String getNumbers(int lower, int upper) {
		String result = "";
		
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		String numbers = "<";
		int count = (upper - lower) + 1;
		if (lower < 0 || upper < 0) {
			result = "Error: both bounds must be non-negative";
		} else if (lower > upper) {
			result = "Error: lower bound " + lower +" is not less than or equal to upper bound " + upper;
		} else if (count == 1) {
			if (lower % 3 == 0) {
				numbers = numbers + "(" + lower + ")";
			} else if (lower % 3 == 1) {
				numbers = numbers + "[" + lower + "]";
			} else if (lower % 3 == 2) {
				numbers = numbers + "{" + lower + "}";
			}
			numbers = numbers + ">";
			result = count + " number between " + lower + " and " + upper + ": " + numbers;
		} else {
			for (int i = lower; i < upper + 1; i++) {
				if (i % 3 == 0) {
					numbers = numbers + "(" + i + ")";
				} else if (i % 3 == 1) {
					numbers = numbers + "[" + i + "]";
				} else if (i % 3 == 2) {
					numbers = numbers + "{" + i + "}";
				}
				if (i != upper) {
					numbers = numbers + ", ";
				}
			}
			numbers = numbers + ">";
			result = count + " numbers between " + lower + " and " + upper + ": " + numbers;
		}
		
		/* Your implementation ends here. */
		
		return result;
	}
	
	/*
	 * Input parameters:
	 * 	- `ft`, `d`, `n` are the first term, common difference, and size of an arithmetic sequence.
	 * 
	 * Use of arrays or any Java library class (e.g., ArrayList) is strictly forbidden.
	 * Violation of this will result in a 50% penalty on your marks.
	 * Try to solve this problem using loops only. 
	 *  
	 * Refer to you lab instructions for what the method should return. 
	 */
	public static String getIntermediateStats(int ft, int d, int n) {
		String result = "";
		
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		result += "{";
		String nums = "";
		int sum = 0;
		int term = ft;
		int i = 1;
		
		if (n == 0) {
			result = "{}";
		} else {
			for (int j = 1; j < n + 1; j++) {
				nums = "<";
				while(i <= j) {
					nums += term;
					if (i < j) {
						nums += ", ";
					}
					sum += term;
					term += d;
					i++;
				}
				nums += ">";
				result += "[sum of " + nums + ": " + sum + " ; avg of " + nums + ": " + String.format("%.2f", ((double)sum/j)) + "]";
				if (j < n) {
					result += ", ";
				} else {
					result += "}";
				}
				i = 1;
				term = ft;
				sum = 0;
			}
		}
		/* Your implementation ends here. */
		return result;
	}
	
	/*
	 * Input parameters:
	 * 	- `ft1`, `d1`, `n1` are the first term, common difference, and size of the first arithmetic sequence.
	 *  - `ft2`, `d2`, `n2` are the second term, common difference, and size of the second arithmetic sequence.
	 *  
	 * Use of arrays or any Java library class (e.g., ArrayList) is strictly forbidden.
	 * Violation of this will result in a 50% penalty on your marks.
	 * Try to solve this problem using loops only.  
	 *  
	 * Refer to you lab instructions for what the method should return. 
	 */
	public static String getInterlevaings(int ft1, int d1, int n1, int ft2, int d2, int n2) {
		String result = "";
		
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		int count = 0;
		String nums = "<";
		int term1 = 0;
		int term2 = 0;
		
		if (n1 > n2) {
			count = n1;
		} else if (n2 >= n1) {
			count = n2;
		}
		if (n1 == 0 && n2 == 0) {
			result = "<>";
		} else {
			for (int j = 1; j < count + 1; j++) {
				if (j < n1 + 1) {
					term1 = ft1 + (d1 * (j - 1));
					nums += "(" + term1 + ")";
					if (j < count) {
						nums += ", ";
					} else if (count == n2) {
						nums += ", ";
					}
				}
				if (j < n2 + 1) {
					term2 = ft2 + (d2 * (j - 1));
					nums += "[" + term2 + "]";
					if (j < count) {
						nums += ", ";
					}
				}
			}
			nums += ">";
			result = nums;
		}
		
		
		/* Your implementation ends here. */
		return result;
	}	
}
