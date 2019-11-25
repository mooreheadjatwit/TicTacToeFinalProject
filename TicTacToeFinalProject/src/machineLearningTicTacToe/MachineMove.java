package machineLearningTicTacToe;


public class MachineMove implements iPlayer {
	//int to represent which player the machine is playing for.
	private int moveNumber = 0;
	//local copy of the current gameState updated each 'play()'
	private int[] moveIndex = {0,0,0,0,0,0,0,0,0};
	//counter of how many times this specific object has won
	private int numWins = 0;
	//instantiates a Machine to be used 
	private Machine mech = new Machine();
	/**
	 * Constructor passed which player (x or o),(2, 1) it will be playing for.
	 * @param turn
	 */
	public MachineMove(int moveNumber) {
		if(moveNumber == 1 || moveNumber == 2) {
			this.moveNumber = moveNumber;
			mech = new Machine(moveNumber);
		} else {
			System.out.println("Error: Incorrect MachineMove usage");
		}
		this.numWins = 0;
	}
	
	@Override
	public void setMove(int move) {
		if(move < 0 || move > 8) {
			System.out.println("Error: setMove used incorrectly");
		}
		int[] temp = Game.getGameState();
		temp[move] = this.moveNumber;
		Game.setGameState(temp);
	}
	
	/**
	 * Main purpose of MachineMove, passes the current gameState to Machine to think on then calls setMove.
	 */
	public void play() {
		this.moveIndex = Game.getGameState();
		int move = mech.think(moveIndex);
		if(move < 0 || move > 8 || moveIndex[move] != 0) {
			System.out.println("Think has given an invalid index.");
		}
		this.setMove(move);
	}
	
	public void randomPlay() {
		this.moveIndex = Game.getGameState();
		boolean chosen = false;
		while(!chosen) {
			int rando = (int)(Math.random()*9);
			if(moveIndex[rando] == 0) {
				setMove(rando);
				chosen = true;
			}
		}
	}

	public int getNumWins() {
		return numWins;
	}

	public void setNumWins() {
		this.numWins++;
	}
	public void learn(int o) {
		this.mech.learn(o);
	}

}
