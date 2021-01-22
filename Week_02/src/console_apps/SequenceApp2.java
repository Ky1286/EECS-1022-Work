package console_apps;

import java.util.Scanner;

import model.Sequence;

public class SequenceApp2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Stage 1: prompt user, read inputs
		System.out.println("Enter the first term (FT) of an arithmetic seq. of size 5:");
		int ft = input.nextInt();
		System.out.println("Enter the common difference (d):");
		int d = input.nextInt();
		
		//Stage 2: Compute result

		String seq = Sequence.getSequence2(ft, d);
		int sum = Sequence.getSum2(ft, d);
		
		//Stage 3: Output result
		System.out.println("Sequence " + seq + " has sum " + sum);
		
		input.close();
	}

}
