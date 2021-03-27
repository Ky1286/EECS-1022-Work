package model;

/*
 * Requirements:
 * - Any use of Java library classes or methods (e.g., ArrayList) is forbidden.
 * 	 (That is, there must not be an import statement in the beginning of this class.)
 * Violation of this requirement will result in a 50% penalty of your marks.
 *  
 * - Use only if-statements and/or loops to manipulate primitive arrays (e.g., int[], String[]).
 */

public class Utilities {
	/*
	 * Input parameters:
	 * 	- `numbers` : an array of integers
	 *  
	 * Refer to you lab instructions for what the method should return. 
	 */
	public static int[] getMultiplesOf3(int[] numbers) {
		int[] result = null;
		
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		int i = 0;
		int j = 0;
		int count = 0;
		while (i < numbers.length) {
			if (numbers[i] % 3 == 0) {
				count++;
			}
			i++;
		}
		i = 0;
		result = new int[count];
		while (i < numbers.length) {
			if (numbers[i] % 3 == 0) {
				result[j] = numbers[i];
				j++;
				i++;
			} else {
				i++;
			}
		}
		
		/* Your implementation ends here. */
		
		return result;
	}	
	
	/*
	 * Input parameters:
	 * 	- `numbers` : an array of integers
	 * 	- `n`		: an integer (which may or may not exist in `numbers`)
	 *  
	 * Refer to you lab instructions for what the method should return. 
	 */
	public static int[] getFilteredSeq(int[] numbers, int n) {
		int[] result = null;
		
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		int i = 0;
		int j = 0;
		int count = 0;
		while (i < numbers.length) {
			if (numbers[i] != n) {
				count++;
				i++;
			} else {
				i++;
			}
		}
		i = 0;
		result = new int[count];
		while (j < count) {
			if (numbers[i] == n) {
				i++;
			} else {
				result[j] = numbers[i];
				j++;
				i++;
			}
		}
		
		/* Your implementation ends here. */
		
		return result;
	}
	
	/*
	 * Input parameters:
	 * 	- `numbers` : an array of integers
	 * 
	 * Assumptions:
	 * 	- numbers.length >= 1
	 *  
	 * Refer to you lab instructions for what the method should return. 
	 */
	public static String[] getAllPrefixes(int[] numbers) {
		String[] result = null;
		
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		
		result = new String[numbers.length];
		String holder = "";
		int count = 0;
		int i = 0;
		
		while (i < numbers.length) {
			holder = "[";
			while (count < i + 1) {
				holder += numbers[count];
				count++;
				if (count < i + 1) {
					holder += ", ";
				} else {
					holder += "]";
				}
			}
			count = 0;
			result[i] = holder;
			i++;
		}
		
		/* Your implementation ends here. */
		
		return result;
	}
	
	/*
	 * Input parameters:
	 * 	- `numbers` : an array of integers
	 *  
	 * Refer to you lab instructions for what the method should return. 
	 */
	public static int[] getGroupedNumbers(int[] numbers) {
		int[] result = null;
		
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		
		int i = 0;
		int j = 0;
		result = new int[numbers.length];
		while (i < numbers.length) {
			if (numbers[i] % 3 == 0) {
				result[j] = numbers[i];
				j++;
			}
			i++;
		}
		i = 0;
		while (i < numbers.length) {
			if (numbers[i] % 3 == 1) {
				result[j] = numbers[i];
				j++;
			}
			i++;
		}
		i = 0;
		while (i < numbers.length) {
			if (numbers[i] % 3 == 2) {
				result[j] = numbers[i];
				j++;
			}
			i++;
		}
		
		/* Your implementation ends here. */
		
		return result;
	}
}
