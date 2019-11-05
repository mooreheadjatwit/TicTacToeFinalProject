package machineLearningTicTacToe;

public class Mutator {
	private int rotated = 0;
	private boolean flipX = false;
	private boolean flipY = false;

	public int findMutation(int[] a) {
		int tri = trinary(a);
		for (int i = 1; i < 4; i++) {
			if(trinary(rotate(a,i)) < tri) {
				tri = trinary(rotate(a,i));
				rotated = i;
			}
		}
		if(trinary(flipX(a)) < tri) {
			tri = trinary(flipX(a));
			flipX = true;
		}
		if(trinary(flipY(a)) < tri) {
			tri = trinary(flipY(a));
			flipY = true;
		}
		if(trinary(flipY(flipX(a))) < tri) {
			tri = trinary(flipY(flipX(a)));
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
	
	public int[] unMutate(int[] a) {
		if (rotated != 0) {
			a = rotate(a, 4 - rotated);
			rotated = 0;
		}
		if (flipX) {
			a = flipX(a);
			flipX = false;
		}
		if (flipY) {
			a = flipY(a);
			flipY = false;
		}
		return a;
	}
	
	private static int[] rotate(int[] B, int num) {
		int[] a = new int[B.length];
		for ( int i = 0; i < B.length; i++)
			a[i] = B[i];
		for (int i = 0; i < num; i++) {
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
	
	private static int[] flipX(int[] B) {
		int[] a = new int[B.length];
		for ( int i = 0; i < B.length; i++)
			a[i] = B[i];
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
	
	private static int[] flipY(int[] B) {
		int[] a = new int[B.length];
		for ( int i = 0; i < B.length; i++)
			a[i] = B[i];
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
	
	public static int trinary(int[] a) {
		int tri = 0;
		for (int i = 0; i < 9; i++) {
			tri += a[8 - i] * Math.pow(3, i);
		}
		return tri;
	}
}
