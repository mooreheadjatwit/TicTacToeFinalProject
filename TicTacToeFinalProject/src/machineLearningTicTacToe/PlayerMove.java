package machineLearningTicTacToe;

public class PlayerMove implements iPlayer {
	private int[] moveIndex = {0,0,0,0,0,0,0,0,0};
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
		//setMove(BoardDisplay.main(null));
		
	}
}
