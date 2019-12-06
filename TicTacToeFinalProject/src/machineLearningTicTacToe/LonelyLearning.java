package machineLearningTicTacToe;

import machineLearningTicTacToe.Game;
import machineLearningTicTacToe.MachineMove;

/**
 * LonelyLearning is the main method to be used when you want to train the machine against itself only
 * 	It uses a similar model to the actual main method now contained within Graphics
 * 	 but instead of two players has two MachineMoves
 * @author moynihanm1
 *
 */
public class LonelyLearning {

	public static void main(String[] args) {
		int tie = 0;
		int one = 0;
		int two = 0;
		//these \/ \/ are to be changed at will 
		int numGames = 100;
		boolean random = true;
		/////////////////////////////
		for(int i = 0; i < numGames; i++) {
			int outcome = mvmGame(random);
			if(outcome == 0) {
				tie++;
			} else if(outcome == 1) {
				one++;
			} else {
				two++;
			}
			Game.resetGameState();
		}
		System.out.printf("After %d games : \nTie: %d\nBot 1: %d\nBot 2%s: %d", numGames, tie, one, (random)? "(Random)": "", two);
		
	}
	
	/**
	 * Runs a game with two machines until completion, has them learn from their mistakes or wins then returns the outcome.
	 * @param rando True if a dumb bot is wanted for Bot 2, False if an equal bot is wanted for Bot 2
	 * @return int corresponding to which Machine won
	 */
	public static int mvmGame(boolean rando) {
		MachineMove m1 = new MachineMove(1);
		MachineMove m2 = new MachineMove(2);
		boolean firstTurn = (Math.random() < .5);
		while(true) {
			if(firstTurn) {
					m1.play();
					if(Game.checkVictory(1)) {
						m1.learn(1);
						m2.learn(2);
						Game.printGameState();
						return 1;
					}
					if(Game.checkTie()) {
						m1.learn(0);
						m2.learn(0);
						Game.printGameState();
						return 0;
					}
					firstTurn = !firstTurn;
					Game.printGameState();
					System.out.println("-------");
				} else {
					if(rando) {
						m2.randomPlay();
					}else {
						m2.play();
					}
					if(Game.checkVictory(2)) {
						m1.learn(2);
						m2.learn(1);
						Game.printGameState();
						return 2;
					}
					if(Game.checkTie()) {
						m1.learn(0);
						m2.learn(0);
						Game.printGameState();
						return 0;
					}
					firstTurn = !firstTurn;
					Game.printGameState();
					System.out.println("-------");
				}
			}
	}
}
