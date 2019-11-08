package machineLearningTicTacToe;

public class Main {
	public static void main(String[] args) {
		PlayerMove player1 = new PlayerMove(1);
		PlayerMove player2 = new PlayerMove(2);
		for(int i = 0; i < 9; i++) {
			if(i%2 == 0) {
				player1.play();
			}
			else {
				player2.play();
			}
			if(Game.getNumMoves() > 4) {
				if(Game.checkVictory(player1.getMoveNumber()) == true) {
					player1.setNumWins();
					Game.resetGameState();
					i = 8;
				}
				else if(Game.checkVictory(player2.getMoveNumber()) == true) {
					player2.setNumWins();
					Game.resetGameState();
					i = 8;
				}
				if(i == 8 && Game.checkTie() == true) {
					Game.resetGameState();
				}
			}
		}
	}
}

