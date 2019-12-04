package machineLearningTicTacToe;

import machineLearningTicTacToe.Game;
import machineLearningTicTacToe.MachineMove;

public class LonelyLearning {

	public static void main(String[] args) {
		int tie = 0;
		int one = 0;
		int two = 0;
		int numGames = 25;
		
		for(int i = 0; i < numGames; i++) {
			int outcome = mvmGame(true);
			if(outcome == 0) {
				tie++;
			} else if(outcome == 1) {
				one++;
			} else {
				two++;
			}
			Game.resetGameState();
		}
		System.out.printf("After %d games : \nTie: %d\nBot 1: %d\nBot 2: %d", numGames, tie, one, two);
		
	}
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
