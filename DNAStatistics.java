import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

// Amaar Zafar, csc403

public class DNAStatistics {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean correctFilePath = false;
		Scanner fileScanner = null;
		while (!correctFilePath) {
			System.out.println("Enter path to a file \"sequences.txt\":");
			String path = scanner.nextLine().trim();
			File file = new File(path);
			try {
				fileScanner = new Scanner(file);
				correctFilePath = true;
			} catch (FileNotFoundException e) {
				System.out.println("Wrong file path");
			}
		}
		scanner.close();
		TreeMap<String, Sequence> symbolTable = parseFile(fileScanner);
		printStatistics(symbolTable);
	}
	
	private static void printStatistics(TreeMap<String, Sequence> symbolTable) {
		symbolTable.forEach((k, v) -> {
			System.out.println(k);
			System.out.println("Number of nucleotides: " + v.nucleotidesNumber);
			System.out.println(v.nucleotidesToString());
			System.out.println("Number of codons: " + v.codonsNumber);
			System.out.println("Number of different codons: " + v.getNumberOfDifferentCodons());
			TreeMap<String, Integer> codonsTable = v.codons; 
			Set<Entry<String, Integer>> codons = codonsTable.entrySet();
			Iterator<Entry<String, Integer>> iterator = codons.iterator();
			while(iterator.hasNext()) {
				for (int index = 0; index < 8; index++) {
					if (iterator.hasNext()) {
						Entry<String, Integer> entry = iterator.next();
						System.out.format("%3s:%3d ", 
								entry.getKey(), 
								entry.getValue());
					}
				}
				System.out.println();	
			}
			System.out.println();
		});
	}
	
	private static TreeMap<String, Sequence> parseFile(Scanner fileScanner) {
		TreeMap<String, Sequence> symbolTable = new TreeMap<>();
		while (fileScanner.hasNext()) {
			String line = fileScanner.nextLine();
			String[] fields = line.split("\t");
			String speciesName = fields[0].trim();
			Sequence sequence = new Sequence();
			String sequenceLine = fields[1].trim();
			for (int index = 0; index < sequenceLine.length(); index += 3) {
				String codon = sequenceLine.substring(index, index + 3);
				sequence.addCodon(codon);
				char[] nucleotides = codon.toCharArray();
				for (char n : nucleotides) {
					sequence.addNucleotide(String.valueOf(n));
				}
			}
			symbolTable.put(speciesName, sequence);
		}
		return symbolTable;
	}
	
	private static class Sequence {
		private TreeMap<Nucleotide, Integer> nucleotides = new TreeMap<>();
		private TreeMap<String, Integer> codons = new TreeMap<>();
		private int nucleotidesNumber = 0;
		private int codonsNumber = 0;
		
		public int getNumberOfDifferentCodons() {
			return codons.size();
		}
		
		public String nucleotidesToString() {
			return "A: " + nucleotides.get(Nucleotide.A) + " " 
				   + "C: " + nucleotides.get(Nucleotide.C) + " " 
				   + "G: " + nucleotides.get(Nucleotide.G) + " "
				   + "T: " + nucleotides.get(Nucleotide.T) + " ";
		}
		
		public void addNucleotide(String nucleotideName) {
			Nucleotide nucleotide = Nucleotide.valueOf(nucleotideName);
			nucleotides.compute(nucleotide, (nucl, number) 
					-> (number == null)? 1 : number + 1);
			codonsNumber++;
			nucleotidesNumber++;
		}
		
		public void addCodon(String codonName) {
			codons.compute(codonName, (c, n) -> (n == null)? 1 : n + 1);
			codonsNumber++;
		}
		
		private enum Nucleotide {
			A, C, G, T;
		}
	}
}
