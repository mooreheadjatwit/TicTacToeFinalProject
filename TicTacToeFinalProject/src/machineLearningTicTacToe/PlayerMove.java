package machineLearningTicTacToe;

/**
 * This is the PlayerMove class, it is used to create a player and
 * have the player be able to make moves in the game
 * 
 * @author Joshua Moorehead
 *
 */

public class PlayerMove implements iPlayer {
	private int[] moveIndex = {0,0,0,0,0,0,0,0,0};
	private int moveNumber;
	private int numWins;
	
	@Override
	public void setMove(int move) {
		//checks if it's a reasonable move to make
		if(move < 9 && move >= 0) {
			moveIndex[move] = this.moveNumber;
			Game.setGameState(moveIndex);
		}
		else {
			System.out.println("Please supply a valid input");
		}
	}
	
	public PlayerMove(int moveNumber) {
		if(moveNumber == 1 || moveNumber == 2) {
			this.moveNumber = moveNumber;
		} else {
			System.out.println("Error: Incorrect PlayerMove usage");
		}
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

	public void play() {
		this.moveIndex = Game.getGameState();
		//here was the statement to call setMove with input from graphics but the functionality has been moved into the new graphics.
	}
}
