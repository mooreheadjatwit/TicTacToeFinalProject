package machineLearningTicTacToe;

/**
 * This is the Player interface it which will be implemented by the PlayerMove and MachineMove classes
 * They both have the setMove and play functions, thus they will both implement it from this interface
 * @author Joshua Moorehead
 *
 */

public interface Player {
	void setMove(int move);
	void play();
}
