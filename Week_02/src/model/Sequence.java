package model;

public class Sequence {
	
	/*
	 * First version
	 */
	
	public static String getSequence1(int ft, int d) {
		String result = "";
		
		int term1 = ft;
		int term2 = ft + d; //term1 + d
		int term3 = ft + 2 * d; //term2 + d
		int term4 = ft + 3 * d; //term3 + d
		int term5 = ft + 4 * d; //term4 + d
		
		String seq = "<" + term1 + ", " + term2 + ", " + term3 + ", " + term4 + ", " + term5 + ">";
		result = seq;
		
		return result;
	}
	
	public static int getSum1(int ft, int d) {
		int result = 0;
		
		int term1 = ft;
		int term2 = ft + d; //term1 + d
		int term3 = ft + 2 * d; //term2 + d
		int term4 = ft + 3 * d; //term3 + d
		int term5 = ft + 4 * d; //term4 + d
		
		int sum = term1 + term2 + term3 + term4 + term5;		
		result = sum;
		
		return result;
	}
	
	/*
	 * Second Version
	 */
	
	public static String getSequence2(int ft, int d) {
		String result = "";
		
		String seq = "<" + ft + ", " + (ft + d) + ", " + (ft + 2 * d) + ", " + (ft + 3 * d) + ", " + (ft + 4 * d) + ">";
		result = seq;
		
		return result;
	}
	
	public static int getSum2(int ft, int d) {
		int result = 0;
		
		int sum = 5 * ft + (1 + 2 + 3 + 4) * d;
		result = sum;
		
		return result;
	}
}
