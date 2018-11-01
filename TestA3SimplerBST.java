package csc403;

import java.util.Arrays;

import stdlib.StdIn;

public class TestA3SimplerBST {
	
	public static void main(String[] args) {
		
		System.out.println("Reading from file...");
		
		// read words
		StdIn.fromFile("data/tale.txt");
		String[] words = StdIn.readAllStrings();
		
		System.out.println("Creating BST from read word and their counts...");
		
		// insert into bst
		A3SimplerBST<String, Integer> bst = new A3SimplerBST<>();
		
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			Integer prevCount = bst.get(word);
			if(prevCount == null)
				prevCount = 0;
			bst.put(word, prevCount + 1); 
		}
		
		System.out.println("Longest Path Length: "+bst.longestPathLength());
		System.out.println("Total leaves: "+bst.leafCount());
		
		// sort words
		Arrays.sort(words);
		
		
		// Insert into new BST
		System.out.println("Creating tree with sorted words...");
		
		A3SimplerBST<String, Integer> sortedBST = new A3SimplerBST<>();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			Integer prevCount = sortedBST.get(word);
			if(prevCount == null)
				prevCount = 0;
			sortedBST.put(word, prevCount + 1); 
		}
		
		System.out.println("Longest Path Length: "+sortedBST.longestPathLength());
		System.out.println("Total leaves: "+sortedBST.leafCount());
	}
	

}
