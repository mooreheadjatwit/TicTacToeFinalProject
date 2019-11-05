package machineLearningTicTacToe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import machineLearningTicTacToe.Mutator;

public class Machine {
	private ArrayList<int[]> brain = new ArrayList<int[]>();
	private ArrayList<Integer> moves = new ArrayList<Integer>();
	private Mutator m = new Mutator();
	
	public Machine() {
		try {
			brain = readData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		moves.clear();
	}
	
	public int think(int[] a) {
		int tri = m.findMutation(a);
		int[] weights = m.unMutate(brain.get(tri));
		int sum = 0;
		for (int w : weights) {
			if(w > 0) {
				sum += w;
			}
		}
		int spin = (int)Math.round(sum * 2 * Math.random());
		int working = 0;
		int j = (int)Math.floor(Math.random()*9);
		for (int i = j; i < sum * 3; i++) {
			if( weights[i % 9] > 0) {
				working += weights[i % 9];
			}
			if( working >= spin) {
				moves.add(Mutator.trinary(a));
				moves.add(i % 9);
				return i % 9;
			}
		}
		return -1;
	}
	
	public void learn(int o) {
		int win = 3;
		int tie = 1;
		int loss = -2;
		for (int i = 0; i < moves.size(); i += 2) {
			brain.get(moves.get(i))[moves.get(i + 1)] += (o == 0)? tie : (o == 1)? win : loss;
		}
	}
	
	public static void writeData(ArrayList<int[]> fullList) throws IOException {
		FileWriter writer = new FileWriter("TESToutput.txt"); 
		for(int[] arr : fullList) {
		  writer.write(Arrays.toString(arr) + System.lineSeparator());
		}
		writer.close();
	}
	
	public static ArrayList<int[]> readData() throws FileNotFoundException{
		Scanner scan = new Scanner(new File("TESToutput.txt"));
		ArrayList<int[]> list = new ArrayList<int[]>();
		while (scan.hasNext()){
		    String line = scan.nextLine();
			if(line.length() > 2) {
				//A modification of a method found from StackOverFlow user YoYo : https://stackoverflow.com/questions/18838781/converting-string-array-to-an-integer-array
				list.add(Stream.of(line.substring(1, line.length() - 1).split(", ")).mapToInt(Integer::parseInt).toArray());
			} else {
				list.add(new int[] {});
			}
		}
		scan.close();
		
		return list;
	}
}
