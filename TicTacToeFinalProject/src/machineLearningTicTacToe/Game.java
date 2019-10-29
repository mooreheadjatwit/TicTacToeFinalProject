package machineLearningTicTacToe;

public class Game {
	private int[] gameState = {0,0,0,0,0,0,0,0,0};
	private int numMoves;
	
	public Game(){
		for(int i = 0; i < this.gameState.length; i++) {
			this.gameState[i] = 0;
		}
		this.numMoves = 0;
	}
	
	public void setGameState(int[] gameState) {
		this.gameState = gameState;
		this.numMoves++;
	}
	
	public int[] getGameState() {
		return this.gameState;
	}
	
	public boolean checkVictory(int condition) {
		if(gameState[4] == condition) {
			if(gameState[1] == gameState[4] && gameState[4] == gameState[7]) {
				return true;
			}
			if(gameState[3] == gameState[4] && gameState[4] == gameState[5]) {
				return true;
			}
			if(gameState[0] == gameState[4] && gameState[4] == gameState[8]) {
				return true;
			}
			if(gameState[2] == gameState[4] && gameState[4] == gameState[6]) {
				return true;
			}
		}
		if(gameState[0] == condition) {
			if(gameState[1] == gameState[0] && gameState[0] == gameState[2]) {
				return true;
			}
			if(gameState[3] == gameState[0] && gameState[0] == gameState[6]) {
				return true;
			}
		}
		if(gameState[8] == condition) {
			if(gameState[6] == gameState[8] && gameState[8] == gameState[7]) {
				return true;
			}
			if(gameState[2] == gameState[8] && gameState[8] == gameState[5]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkTie() {
		if(this.numMoves == 9 && this.checkVictory(1) == false && this.checkVictory(2) == false) {
			return true;
		}
		return false;
	}
	
	public void resetGameState() {
		for(int i = 0; i < this.gameState.length; i++) {
			this.gameState[i] = 0;
		}
		this.numMoves = 0;
	}
}
