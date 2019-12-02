package machineLearningTicTacToe;

public class Main {
	public static void main(String[] args) {
		boolean pvp = false;
		boolean firstTurn;
		int outcome;
		//comment
		//TODO uncomment this \/\/\/\/\/\/\/\/\/
		//pvp = Graphics.initialDisplay();
		while(true){
			
		firstTurn = (Math.random() < .5);
		outcome = playGame(pvp, firstTurn);
		System.out.println(outcome);
		}
		/*
		if(outcome == 1) {
			Graphics.victoryScreen();
		}
		if(outcome == 2) {
			Graphics.lossScreen();
		}
		if(outcome == 0) {
			Graphics.tieScreen();
		}
		*/
	}
	
	public static int playGame(boolean pvp, boolean firstTurn) {
		Game.resetGameState();
		if(pvp) {
			PlayerMove player1 = new PlayerMove(1);
			PlayerMove player2 = new PlayerMove(2);
			while(Game.getNumMoves() < 10) {
				if(firstTurn) {
					player1.play();
					if(Game.checkVictory(1)) {
						return 1;
					}
					if(Game.checkTie()) {
						return 0;
					}
					firstTurn = !firstTurn;
				} else {
					player2.play();
					if(Game.checkVictory(2)) {
						return 2;
					}
					if(Game.checkTie()) {
						return 0;
					}
					firstTurn = !firstTurn;
				}
			}
		} else {
			PlayerMove player = new PlayerMove(1);
			MachineMove mech = new MachineMove(2);
			while(true) {
			if(firstTurn) {
					player.play();
					if(Game.checkVictory(1)) {
						mech.learn(2);
						return 1;
					}
					if(Game.checkTie()) {
						mech.learn(0);
						return 0;
					}
					firstTurn = !firstTurn;
				} else {
					mech.play();
					if(Game.checkVictory(2)) {
						mech.learn(1);
						return 2;
					}
					if(Game.checkTie()) {
						mech.learn(0);
						return 0;
					}
					firstTurn = !firstTurn;
				}
			}
		}
		return -1;
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
						m2.learn(2);
						return 1;
					}
					if(Game.checkTie()) {
						m1.learn(0);
						m2.learn(0);
						return 0;
					}
					firstTurn = !firstTurn;
				} else {
					m2.play();
					if(Game.checkVictory(2)) {
						m2.learn(1);
						m1.learn(2);
						return 2;
					}
					if(Game.checkTie()) {
						m1.learn(0);
						m2.learn(0);
						return 0;
					}
					firstTurn = !firstTurn;
				}
			}
	}
}

