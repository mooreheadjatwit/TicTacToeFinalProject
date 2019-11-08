package machineLearningTicTacToe;

/**
 * This is the game class it holds all the information on the tic tac toe gameboard
 * When a new game is created the gameState array is set to all 0s and the number of moves is set to zero
 * It has a getGameState and setGameState respectively. Also it has the ability to reset the gameState
 * @author Joshua Moorehead
 *
 */

public class Game {
	private static int[] gameState = {0,0,0,0,0,0,0,0,0};
	private static int numMoves;
	
	public Game(){
		resetGameState();
	}
	
	public static void setGameState(int[] newGameState) {
		gameState = newGameState;
		numMoves++;
	}
	
	public static int[] getGameState() {
		return gameState;
	}
	
	public static int getNumMoves() {
		return numMoves;
	}
	
	public static boolean checkVictory(int condition) {//If there are 3 in a row that are all equal to the condition it is true
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
	
	public static boolean checkTie() {
		if(numMoves == 9 && checkVictory(1) == false && checkVictory(2) == false) {
			return true;
		}
		return false;
	}
	
	public static void resetGameState() {
		for(int i = 0; i < gameState.length; i++) {
			gameState[i] = 0;
		}
		numMoves = 0;
	}
}
