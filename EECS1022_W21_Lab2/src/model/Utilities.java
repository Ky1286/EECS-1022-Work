package model;

public class Utilities {
	/*
	 * Input parameters:
	 * 	- `status` is the filing status (which should be 1 for Single Filing or 2 for Married Filing)
	 *  - `income` is the tax payer's income (an integer value)
	 *  
	 * Assumptions:
	 * 	- `income` passed by user is always positive (> 0)
	 *  
	 * Refer to you lab instructions for what the method should return.
	 * 
	 * See this short tutorial video illustrating how to compute tax:
	 * https://www.youtube.com/watch?v=q2NT5x77hdg&list=PL5dxAmCmjv_7YgI2LgcwjWTHiNZSR-aQX&index=1 
	 */
	public static String getTaxReport(int status, int income) {
		String result = "";
		
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		double dIncome = income;
		double thirdSplit = 0;
		double secondSplit = 0;
		double firstSplit = 0;
		double total = 0;
		if (status == 1) {
			if (income > 33950) {
				thirdSplit = (dIncome - 33950) * 0.25;
				secondSplit = 3840;
				firstSplit = 835;
				total = thirdSplit + secondSplit + firstSplit;
				result = "Single Filing: $" + String.format("%.2f", total) 
				+ " (Part I: $" + String.format("%.2f", firstSplit) 
				+ ", Part II: $" + String.format("%.2f", secondSplit) 
				+ ", Part III: $" + String.format("%.2f", thirdSplit) + ")";
			} else if (8350 < income && income <= 33950) {
				secondSplit = (dIncome - 8350) * 0.15;
				firstSplit = 835;
				total = secondSplit + firstSplit;
				result = "Single Filing: $" + String.format("%.2f", total) 
				+ " (Part I: $" + String.format("%.2f", firstSplit) 
				+ ", Part II: $" + String.format("%.2f", secondSplit) 
				+ ")";
			} else {
				firstSplit = dIncome * 0.1;
				total = firstSplit;
				result = "Single Filing: $" + String.format("%.2f", total) 
				+ " (Part I: $" + String.format("%.2f", firstSplit) 
				+ ")";
			}
		} else if (status == 2){
			if (income > 67900) {
				thirdSplit = (dIncome - 67900) * 0.25;
				secondSplit = 7680;
				firstSplit = 1670;
				total = thirdSplit + secondSplit + firstSplit;
				result = "Married Filing: $" + String.format("%.2f", total) 
				+ " (Part I: $" + String.format("%.2f", firstSplit) 
				+ ", Part II: $" + String.format("%.2f", secondSplit) 
				+ ", Part III: $" + String.format("%.2f", thirdSplit) + ")";
			} else if (16700 < income && income <= 67900) {
				secondSplit = (dIncome - 16700) * 0.15;
				firstSplit = 1670;
				total = secondSplit + firstSplit;
				result = "Married Filing: $" + String.format("%.2f", total) 
				+ " (Part I: $" + String.format("%.2f", firstSplit) 
				+ ", Part II: $" + String.format("%.2f", secondSplit) 
				+ ")";
			} else {
				firstSplit = dIncome * 0.1;
				total = firstSplit;
				result = "Married Filing: $" + String.format("%.2f", total) 
				+ " (Part I: $" + String.format("%.2f", firstSplit)  
				+ ")";
			}
		}
		else {
			result = "Illegal Status: " + status;
		}
		
		
		/* Your implementation ends here. */

		return result;
	}
	
	/*
	 * Input parameters:
	 * 	- `p1` is the name of player 1
	 *  - `p2` is the name of player 2
	 *  - `p1r1` is what player 1 plays in round 1 ('R', 'P', or 'S')
	 *  - `p2r1` is what player 2 plays in round 1 ('R', 'P', or 'S')
	 *  - `p1r2` is what player 1 plays in round 2 ('R', 'P', or 'S')
	 *  - `p2r2` is what player 2 plays in round 2 ('R', 'P', or 'S')
	 *  
	 * Assumptions:
	 * 	- `p1r1`, `p2r1`, `p1r2`, or `p2r2` is one of the following characters:
	 *     'R' for rock, 'P' for paper, and 'S' scissors (case-sensitive)
	 *     
	 * Hints:
	 *  - Compare character values using the relational operator ==.
	 *  - Study the 9 test cases in TestUtilites: they are arranged in a systematic (yet not exhaustive) way.
	 *    Q. In order to exhaustively test this game, considering how two players may play in two rounds,
	 *    	 how many tests do we need? (Optionally, you may write extra test yourself as an exercise.)
	 *    
	 * Refer to you lab instructions for what the method should return.
	 */
	public static String getRPSGameReport(String p1, String p2, char p1r1, char p2r1, char p1r2, char p2r2) {
		String result = "";
		
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		String r1 = "";
		String r2 = "";
		String game = "";
		int p1Points = 0;
		int p2Points = 0;
		String r1Result = "";
		String r2Result = "";
		
		//Instead of using '' like a smart person, i forgot and used the ASCII values of the characters R, P, and S
		
		if (p1r1 == p2r1) {
			r1 = "Tie";
			r1Result = "(" + p1r1 + " vs. " + p2r1 + ")";
		} else if (p1r1 == 82 && p2r1 == 83 || p1r1 == 83 && p2r1 == 80 || p1r1 == 80 && p2r1 == 82) {
			r1 = p1 + " wins";
			p1Points = p1Points + 1;
			r1Result = "(" + p1r1 + " vs. " + p2r1 + ")";
		} else {
			r1 = p2 + " wins";
			p2Points = p2Points + 1;
			r1Result = "(" + p2r1 + " vs. " + p1r1 + ")";
		}
		
		if (p1r2 == p2r2) {
			r2 = "Tie";
			r2Result = "(" + p1r2 + " vs. " + p2r2 + ")";
		} else if (p1r2 == 82 && p2r2 == 83 || p1r2 == 83 && p2r2 == 80 || p1r2 == 80 && p2r2 == 82) {
			r2 = p1 + " wins";
			p1Points = p1Points + 1;
			r2Result = "(" + p1r2 + " vs. " + p2r2 + ")";
		} else {
			r2 = p2 + " wins";
			p2Points = p2Points + 1;
			r2Result = "(" + p2r2 + " vs. " + p1r2 + ")";
		}
		
		if (p1Points > p2Points) {
			game = p1 + " wins!";
		} else if (p2Points > p1Points) {
			game = p2 + " wins!";
		} else {
			game = "Tie!";
		}
		
		result = "Game over: " + game + " [Round 1: " + r1 + " " + r1Result + " ; Round 2: " + r2 + " " + r2Result + "]";
		/* Your implementation ends here. */

		return result;
	}
}
