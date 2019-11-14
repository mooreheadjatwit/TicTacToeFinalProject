package machineLearningTicTacToe;

public class MachineMove implements iPlayer {
	//int to represent which player the machine is playing for.
	private int turn = 0;
	//local copy of the current gameState updated each 'play()'
	private int[] moveIndex = {0,0,0,0,0,0,0,0,0};
	//instantiates a Machine to be used 
	private Machine mech = new Machine();
	/**
	 * Constructor passed which player (x or o),(2, 1) it will be playing for.
	 * @param turn
	 */
	public MachineMove(int turn) {
		if(turn == 1 || turn == 2) {
			this.turn = turn;
		} else {
			System.out.println("Error: Incorrect MachineMove usage");
		}
	}
	
	@Override
	public void setMove(int move) {
		int[] temp = Game.getGameState();
		temp[move] = this.turn;
		Game.setGameState(temp);
	}
	
	/**
	 * Main purpose of MachineMove, passes the current gameState to Machine to think on then calls setMove.
	 */
	public void play() {
		this.moveIndex = Game.getGameState();
		this.setMove(mech.think(moveIndex));

	}

}
