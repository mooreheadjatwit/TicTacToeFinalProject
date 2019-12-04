package machineLearningTicTacToe;

/**
 * Mutator is class for all the methods related to mutation (flips and rotations) of the gameboard.
 * 
 * @author Max Moynihan
 *
 */
public class Mutator {
	//instance variables store the most recent mutation values so it can be undone after fetching the weight array
	private int rotated = 0;
	private boolean flipX = false;
	private boolean flipY = false;

	/**
	 * FindMutation iterates through combinations of flips and rotations
	 *  to find a common trinary value for each strategic equivalence
	 * @param a is a gameState array 
	 * @return the smallest trinary value int
	 */
	public int findMutation(int[] a) {
		int tri = trinary(a);
		rotated = 0;
		flipX = false;
		flipY = false;
		for (int i = 1; i < 4; i++) {
			if(trinary(rotate(a,i)) < tri) {
				tri = trinary(rotate(a,i));
				rotated = i;
			}
		}
		if(trinary(flipX(a)) < tri) {
			tri = trinary(flipX(a));
			rotated = 0;
			flipX = true;
		}
		if(trinary(flipY(a)) < tri) {
			tri = trinary(flipY(a));
			rotated = 0;
			flipY = true;
		}
		if(trinary(flipY(flipX(a))) < tri) {
			tri = trinary(flipY(flipX(a)));
			rotated = 0;
			flipY = true;
			flipX = true;
		}
		for (int i = 1; i < 4; i++) {
			if(trinary(rotate(flipX(a),i)) < tri) {
				tri = trinary(rotate(flipX(a),i));
				rotated = i;
				flipX = true;
			}
		}
		for (int i = 1; i < 4; i++) {
			if(trinary(rotate(flipY(a),i)) < tri) {
				tri = trinary(rotate(flipY(a),i));
				rotated = i;
				flipY = true;
			}
		}
		for (int i = 1; i < 4; i++) {
			if(trinary(rotate(flipY(flipX(a)),i)) < tri) {
				tri = trinary(rotate(flipY(flipX(a)),i));
				rotated = i;
				flipY = true;
				flipX = true;
			}
		}
		return tri;
	}
	
	/**
	 * UnMutate uses the instance variables to perform the opposite transformations on a given weight array.
	 * @param a an int array, in this project always the weight array
	 * @return the input array but transformed to be relevant to the current gameState
	 */
	public int[] unMutate(int[] a) {
		if(a.length != 9) {
			System.out.println("Error: unMutate used incorrectly.");
			System.out.println("tri case may not be in database");
			System.exit(0);
		}
		if (this.rotated != 0) {
			a = rotate(a, 4 - this.rotated);
		}
		if (this.flipX) {
			a = flipX(a);
		}
		if (this.flipY) {
			a = flipY(a);
		}
		return a;
	}
	
	public int mutateIndex(int a) {
		int[] temp = {0,0,0,0,0,0,0,0,0};
		temp[a] = 1;
		if(flipX) {
			temp = flipX(temp);
		}
		if(flipY) {
			temp = flipY(temp);
		}
		temp = rotate(temp, rotated);
		for(int i = 0; i < 9; i++) {
			if(temp[i] == 1) {
				return i;
			}
		}
		return a;
	}
	/**
	 * Rotate is a hardcoded rotate mapping that is done num of times.
	 * @param B input array
	 * @param num # of times to rotate
	 * @return a copy of input array but rotated 
	 */
	private static int[] rotate(int[] B, int num) {
		int[] a = new int[B.length];
		//this is necessary to return a new array instead of modifying the passed array because the object address is passed.
		for ( int i = 0; i < B.length; i++) {
			a[i] = B[i];
		}
		for (int i = 0; i < num; i++) {
			//temp variables, 'eh' in place of 'a' because it was used elsewhere
			int eh = a[0];
			int b = a[1];
			int c = a[2];
			a[0] = a[6];
			a[1] = a[3];
			a[2] = eh;
			a[3] = a[7];
			a[6] = a[8];
			a[7] = a[5];
			a[8] = c;
			a[5] = b;
		}
		return a;
	}
	
	/**
	 * FlipX is simply a hardcoded flip in the X direction.
	 * @param B input array
	 * @return copy of input array but flipped
	 */
	private static int[] flipX(int[] B) {
		int[] a = new int[B.length];
		//again a copy needs to be manually made so the original is not modified
		for ( int i = 0; i < B.length; i++) {
			a[i] = B[i];
		}
		int eh = a[0];
		int b = a[3];
		int c = a[6];
		a[0] = a[2];
		a[3] = a[5];
		a[6] = a[8];
		a[2] = eh;
		a[5] = b;
		a[8] = c;
		return a;
	}
	
	/**
	 * FlipY is simply a hardcoded flip in the Y direction.
	 * @param B input array
	 * @return copy of input array but flipped
	 */
	private static int[] flipY(int[] B) {
		int[] a = new int[B.length];
		for ( int i = 0; i < B.length; i++) {
			a[i] = B[i];
		}
		int eh = a[0];
		int b = a[1];
		int c = a[2];
		a[0] = a[6];
		a[1] = a[7];
		a[2] = a[8];
		a[6] = eh;
		a[7] = b;
		a[8] = c;
		return a;
	}
	
	/**
	 * Trinary is a base-3 to base-10 converter where the input is an array representation of the gameState.
	 * The reason for this is so the database can be accessed easily where the gameState is just the line number,
	 * if we did that without conversion the database would be 200 million lines long instead of 17 thousand.
	 * @param a input array (base-3)
	 * @return int in base-10
	 */
	public static int trinary(int[] a) {
		int tri = 0;
		for (int i = 0; i < 9; i++) {
			tri += a[8 - i] * Math.pow(3, i);
		}
		return tri;
	}
}
