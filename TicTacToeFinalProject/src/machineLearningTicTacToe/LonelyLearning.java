package machineLearningTicTacToe;

import machineLearningTicTacToe.Game;
import machineLearningTicTacToe.MachineMove;

public class LonelyLearning {

	public static void main(String[] args) {
		int tie = 0;
		int one = 0;
		int two = 0;
		int numGames = 50;
		Machine test = new Machine(2);
		int[] array = new int[] {2,0,0,1,1,2,0,0,1};
		//System.out.println(Mutator.trinary(array));
		//for(int i = 0; i < 50; i++)
		//System.out.println(test.think(array));
		//Mutator muttate = new Mutator();
		//System.out.println(muttate.findMutation(array));
		
		
		for(int i = 0; i < numGames; i++) {
			int outcome = mvmGame();
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
	public static int mvmGame() {
		MachineMove m1 = new MachineMove(1);
		MachineMove m2 = new MachineMove(2);
		boolean firstTurn = (Math.random() < .5);
		while(true) {
			if(firstTurn) {
					m1.play();
					if(Game.checkVictory(1)) {
						m1.learn(1);
						Game.printGameState();
						return 1;
					}
					if(Game.checkTie()) {
						m1.learn(0);
						Game.printGameState();
						return 0;
					}
					firstTurn = !firstTurn;
					Game.printGameState();
					System.out.println("-------");
				} else {
					m2.randomPlay();
					if(Game.checkVictory(2)) {
						m1.learn(2);
						Game.printGameState();
						return 2;
					}
					if(Game.checkTie()) {
						m1.learn(0);
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
