package csc403;
import algs31.*;
import stdlib.*;

// Amaar Zafar csc403

public class ComputeARR {
	
	public static void main(String[] args) {
	BinarySearchST<String, Double> sTable = new BinarySearchST<>();
	
	sTable.put("Outstanding", 6.0);
	sTable.put("Excellent", 5.0);
	sTable.put("Better", 4.0);
	sTable.put("Average", 3.0);
	sTable.put("Worse", 2.0);
	sTable.put("Awful", 1.0);
	sTable.put("Avoid", 0.0);
	
	StdIn.fromFile("src/a1ratings.txt");
	String[] fileContent = StdIn.readAllStrings();
	
	float totScore = 0;
	float lat = 0;
	
	for(String i : fileContent) {
		if(sTable.contains(i)) {
			totScore += sTable.get(i);
			lat += 1;
		}
	}
	float averageScore = totScore/lat;
	
	StdOut.println("Avg val of scores: " + averageScore);
		
	
	}
}

	
