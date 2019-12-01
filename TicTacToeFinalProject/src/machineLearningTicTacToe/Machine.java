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

/**
 * Machine handles the interfacing with the bigBrain database, thinking, and learning.
 * @author moynihanm1
 *
 */
public class Machine {
	//brain is the runtime database to reference and modify
	private ArrayList<int[]> brain = new ArrayList<int[]>();
	//moves stores the moves of the past game to learn from
	private ArrayList<Integer> moves = new ArrayList<Integer>();
	private Mutator m = new Mutator();
	int moveNumber = 0;
	
	public Machine() {
		try {
			brain = readData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.moveNumber = 2;
		//clears moves for a new game to be played
		moves.clear();
	}
	
	public Machine(int moveNumber) {
		try {
			brain = readData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.moveNumber = moveNumber;
		//clears moves for a new game to be played
		moves.clear();
		m = new Mutator();
	}

	/**
	 * Think is the main method of machineLearning. It takes in a gameState array 'a' and returns the index that should be played.
	 * @param a
	 * @return
	 */
	public int think(int[] a) {
		//uses the trinary value of the array to get the line# to go to in bigBrain
		int tri = -1;
		if(this.moveNumber == 2) {
			tri = m.findMutation(a);
		} else if(this.moveNumber == 1) {
			tri = m.findMutation(invert(a));
		}
		//re-arranges the weight matrix to be applicable to this mutation
		//System.out.println(tri);
		int[] weights = m.unMutate(brain.get(tri));
		//System.out.println(Arrays.toString(weights));
		//System.out.println(tri);
		int sum = 0;
		int totalOptions = 0;
		for (int w : weights) {
			if(w > 0) {
				totalOptions++;
				sum += w;
			}
		}
		if(sum == 0) {
			System.out.println("This option has killed itself");
			System.out.println(tri);
			System.exit(0);
		}
		if(totalOptions == 1) {
			for (int i = 0; i < 9; i++) {
				if(weights[i] > 0) {
					return i;
				}
			}
		}
		//the following part randomly selects a move according to the weights
		//it is not very efficient but it is the best I could think of
		//the logic is similar to that of a roulette wheel
		int spin = (int)Math.round(sum * Math.random());
		int working = 0;
		int j = (int)Math.floor(Math.random()*9);
		int choice = 0;
		for (int i = j; i < sum * 100; i++) {
			if(weights[i % 9] > 0) {
				working += weights[i % 9];
			
				if(working >= spin) {
					if(a[i % 9] == 0) {
						moves.add(tri);
						moves.add(m.mutateIndex(i % 9));
						return i % 9;
					} else {
						System.out.println("A think error has occured. Trying again.------------");
						return this.think(a);
					}
				}
			}
		}
		System.out.println("A think error has occured. Trying again.");
		return this.think(a);
	}
	
	/**
	 * Learn is for after a game is resolved. It goes through its past moves and modifies them according to the outcome 'o'.
	 * @param o  [0 : tie, 1 : win, 2 : loss]
	 */
	public void learn(int o) {
		int win = 3;
		int tie = 0;
		int loss = -3;
		try {
			this.brain = readData();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		for (int i = 0; i < moves.size(); i += 2) {
			
			brain.get(moves.get(i))[moves.get(i + 1)] += (o == 0)? tie : (o == 1)? win : loss;
			if(brain.get(moves.get(i))[moves.get(i + 1)] < 0) {
				brain.get(moves.get(i))[moves.get(i + 1)] = 0;
			}
			int sum = 0;
			for(int j = 0; j < 9; j++) {
				sum += brain.get(moves.get(i))[j];
			}
			if(sum / 9 > 50) {
				for(int k = 0; k < 9; k++) {
					brain.get(moves.get(i))[k] = (int)Math.ceil(brain.get(moves.get(i))[k]/3.0);
				}
			}
		}
		try {
			writeData(brain);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int[] invert(int[] array) {
		int[] temp = {0,0,0,0,0,0,0,0,0};
		for(int i = 0; i < array.length; i++) {
			if(array[i] == 1) {
				temp[i] = 2;
			} else if(array[i] == 2){
				temp[i] = 1;
			}
		}
		return temp;
	}
	/**
	 * WriteData writes the runtime array into storage as 'bigBrain.txt' in the same directory as the classes.
	 * @param fullList  ArrayList to write
	 * @throws IOException
	 */
	public static void writeData(ArrayList<int[]> fullList) throws IOException {
		FileWriter writer = new FileWriter("./src/machineLearningTicTacToe/bigBrain.txt"); 
		//modification of a method from StackOverflow User Andrey Adamovich : 
		//https://stackoverflow.com/questions/6548157/how-to-write-an-arraylist-of-strings-into-a-text-file
		for(int[] arr : fullList) {
			writer.write(Arrays.toString(arr) + System.lineSeparator());
		}
		writer.close();
	}
	
	/**
	 * ReadData parses the data from bigBrain file and returns it as the ArrayList 
	 * @return ArrayList of int arrays to be used as the runtime array.
	 * @throws FileNotFoundException
	 */
	public static ArrayList<int[]> readData() throws FileNotFoundException{
		Scanner scan = new Scanner(new File("./src/machineLearningTicTacToe/bigBrain.txt"));
		ArrayList<int[]> list = new ArrayList<int[]>();
		while (scan.hasNext()){
		    String line = scan.nextLine();
			if(line.length() > 2) {
				//A modification of a method found from StackOverFlow user YoYo : 
				//https://stackoverflow.com/questions/18838781/converting-string-array-to-an-integer-array
				list.add(Stream.of(line.substring(1, line.length() - 1).split(", ")).mapToInt(Integer::parseInt).toArray());
			} else {
				list.add(new int[] {});
			}
		}
		scan.close();
		
		return list;
	}
}
