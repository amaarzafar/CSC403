package csc403;
import stdlib.*;

//Amaar Zafar, CSC403

public class FileMaxMin {
	public static void main(String[] args) {
		StdIn.fromFile("src/100ints.txt");
		String[] inputString = StdIn.readAllStrings();
		int[] totalInts = new int[inputString.length];
		
		for(int i = 0; i < inputString.length; i++)
			totalInts[i] = Integer.parseInt(inputString[i]);
		
		int max = 0;
		int min = 0;
		
		for(int i = 0; i < totalInts.length; i++) {
			if (totalInts[i] > max) max = totalInts[i];
			if (totalInts[i] < min) min = totalInts[i];
		}
		StdOut.println("the largest value is: " + max);
		StdOut.println("the smallest value is: " + min);
	}
}
