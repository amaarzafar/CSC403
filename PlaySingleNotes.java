package csc403;

import stdlib.StdAudio;
import stdlib.StdIn;
import stdlib.StdOut;
import java.util.ArrayList;
import algs31.BinarySearchST;

// Amaar Zafar csc403

public class PlaySingleNotes {

	//teachers code given online
	public static void playNote(double duration, double frequency) {
		final int sliceCount = (int) (StdAudio.SAMPLE_RATE * duration);
		final double[] slices = new double[sliceCount+1];
		for (int i = 0; i <= sliceCount; i++) {
			slices[i] += Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
		}
		StdAudio.play(slices);
	}
	
	public static void main(String[] args) {
		
		StdIn.fromFile("src/notes_frequencies.txt");
		BinarySearchST<String,Double> frequencySymbolTable = new BinarySearchST<>();
		while (StdIn.hasNextLine()) {
			String contents = StdIn.readLine();
			String[] contentSpl = contents.split("\\s+");
			frequencySymbolTable.put(contentSpl[0],Double.parseDouble(contentSpl[1]));
		}
		StdIn.fromFile("src/single_notes.txt");
	
		while(StdIn.hasNextLine()) {
			String[] playNotes = StdIn.readLine().split("\\s+");
			playNote(Double.parseDouble(playNotes[0]),frequencySymbolTable.get(playNotes[1]));
		}
		
	}
}


