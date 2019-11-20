package machineLearningTicTacToe;

public class Main {
	public static void main(String[] args) {
		boolean pvp = false;
		boolean firstTurn;
		int outcome;
		//TODO uncomment this \/\/\/\/\/\/\/\/\/
		//pvp = Graphics.initialDisplay();
		firstTurn = (Math.random() < .5);
		outcome = playGame(pvp, firstTurn);
		System.out.println(outcome);
		if(outcome == 1) {
			//TODO uncomment
			//Graphics.victoryScreen();
		}
		if(outcome == 2) {
			//TODO uncomment
			//Graphics.lossScreen();
		}
		if(outcome == 0) {
			//TODO uncomment
			//Graphics.tieScreen();
		}
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
}

