package machineLearningTicTacToe;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			System.out.println("Would you like to play a game");
			int choice = s.nextInt();
			PlayerMove player1 = new PlayerMove(1);
			PlayerMove player2 = new PlayerMove(2);
			do {
				
				for(int i = 0; i < 9; i++) {
					if(i%2 == 0) {
						Game.printGameState();
						System.out.println("Player 1 chose your move");
						int move = s.nextInt();
						player1.setMove(move);
					}
					else {
						Game.printGameState();
						System.out.println("Player 2 chose your move");
						int move = s.nextInt();
						player2.setMove(move);
					}
					if(Game.getNumMoves() > 4) {
						if(Game.checkVictory(player1.getMoveNumber()) == true) {
							player1.setNumWins();
							System.out.println("Player1 has won");
							break;
						}
						else if(Game.checkVictory(player2.getMoveNumber()) == true) {
							player2.setNumWins();
							System.out.println("Player2 has won");
							break;
						}
						if(i == 8 && Game.checkTie() == true) {
							System.out.println("The game is tied");
					}
				}
			}
			Game.printGameState();
			Game.resetGameState();
			System.out.println("Enter 1 to play again");
			choice = s.nextInt();
		
		
		}while(choice == 1);
		System.out.println("Good Bye!");
		s.close();
	}
}

