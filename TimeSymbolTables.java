package csc403;

import algs31.SequentialSearchST;
import algs32.BST ;
import stdlib.*;

// Amaar Zafar, csc 403

public class TimeSymbolTables {

	public static void main(String[] args) {
		
	StdIn.fromFile("data/tale.txt");
	String[] contents = StdIn.readAllStrings();
	//reads string
	Stopwatch varOne = new Stopwatch();
	SequentialSearchST<String,Integer> SqSr = new SequentialSearchST<>();
	//creates new sequential search ST
	for(String curr: contents) {
		if(!SqSr.contains(curr)) {
			SqSr.put(curr, 1);
		}else{
			SqSr.put(curr,SqSr.get(curr)+1);
		}			
	}
	
	StdOut.println("Elapsed SequentialSearchST time is: " + varOne.elapsedTime() + " seconds");
	
	varOne = new Stopwatch();
	
	BST<String,Integer> BstTime = new BST<>();
	
	for(String curr: contents) {
		if(!BstTime.contains(curr)) {
			BstTime.put(curr, 1);
		}else{
			BstTime.put(curr,BstTime.get(curr)+1);
		}		
		
	}
	StdOut.println("Elapsed BST time is: " + varOne.elapsedTime() + " seconds");
	}

}
 