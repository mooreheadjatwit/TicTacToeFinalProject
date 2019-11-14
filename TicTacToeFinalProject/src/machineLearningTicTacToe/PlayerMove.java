package machineLearningTicTacToe;

import java.util.Scanner;

public class PlayerMove implements iPlayer {
	private int[] moveIndex;
	private int moveNumber;
	private int numWins;
	
	@Override
	public void setMove(int move) {
		if(move < 9 && move >= 0) {
			moveIndex[move] = this.moveNumber;
			Game.setGameState(moveIndex);
		}
		else {
			System.out.println("Please supply a valid input");
		}
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
