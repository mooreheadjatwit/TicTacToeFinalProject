package machineLearningTicTacToe;

import java.util.Scanner;

public class PlayerMove implements Player {
	private int[] moveIndex;
	private int moveNumber;
	private int numWins;
	
	@Override
	public void setMove(int move) {
		moveIndex[move] = this.moveNumber;
		Game.setGameState(moveIndex);
	}

	@Override
	public void play() {
		/*Scanner s = new Scanner(System.in);
		this.moveIndex = Game.getGameState();
		for(int i = 1; i < this.moveIndex.length + 1; i++) {
			System.out.printf("%d", this.moveIndex[i-1]);
			if(i%3 == 0) {
				System.out.println();
			}
		}
		System.out.printf("%nChose your move Player%n");
		int moveNumber = s.nextInt();
		setMove(moveNumber);
		s.close();*/
	}
	
	public PlayerMove(int moveNumber) {
		this.moveNumber = moveNumber;
		this.moveIndex = Game.getGameState();
		this.numWins = 0;
	}
	
	public int getNumWins() {
		return this.numWins;
	}
	
	public void setNumWins() {
		this.numWins++;
	}
	
	public int getMoveNumber(){
		return this.moveNumber;
	}
}
