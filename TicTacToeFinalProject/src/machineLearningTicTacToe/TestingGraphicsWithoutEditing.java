package machineLearningTicTacToe;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class TestingGraphicsWithoutEditing extends Application {
	static Stage start;
	static Scene origin, PvP, PvM, tieScreen, loseScreen;
	static int move = -1;
	static int pvp = 0;
	private static int[] moveIndex = new int[] {0,0,0,0,0,0,0,0,0};
	static int playerWins = 0;
	static int machineWins = 0;
	static int numTies = 0;
	static JButton PvM0 = new JButton("Location 0");
	static JButton PvM1 = new JButton("Location 1");
	static JButton PvM2 = new JButton("Location 2");
	static JButton PvM3 = new JButton("Location 3");
	static JButton PvM4 = new JButton("Location 4");
	static JButton PvM5 = new JButton("Location 5");
	static JButton PvM6 = new JButton("Location 6");
	static JButton PvM7 = new JButton("Location 7");
	static JButton PvM8 = new JButton("Location 8");

	
	public static int getMove() {
		return move;
	}
	
	public static int getChoice() {
		return pvp;
	}
	
	public static void setMoveIndex(int[] index) {
		
	}
	
	public static void setStage(Scene scene) {
		start.setScene(scene);
	}
	
	public static boolean isValid(int n) {
		if(n < 9 && n >= 0) {
			if(moveIndex[n] == 0) {
				return true;
			}
		}
		return false;
	}
	
	public static Text xOOrBlank(int n) {
		int state = n;
		Text xText = new Text("X");
		Text oText = new Text("O");
		Text blankText = new Text(" ");

		xText.setStyle("-fx-font: 32 arial;");
		oText.setStyle("-fx-font: 32 arial;");
		blankText.setStyle("-fx-font: 32 arial;");

		
		if (state > 0) {
			if (state == 1) {
				return xText;
			} else {
				return oText;
			}

		}
		return blankText;
		
	}
	
	public static Scene resetBoard() {
		move = -1;
		Game.resetGameState();
		for(int i = 0; i < 9; i++) {
			moveIndex[i] = Game.getGameState()[i];
		}
//		Button PvM0 = new Button("Location 0");
//		PvM0.setOnAction(e->{
//			if(isValid(0)) {
//				//moveIndex[0] = Main.getTurn() ? 1 : 2;
//				//Main.setTurn();
//				//Game.setGameState(moveIndex);
//				move = 0;
//			}
//			else {
//				start.close();
//			}
//			//start.setScene(updateBoard());
//		});
//		Button PvM1 = new Button("Location 1");
//		PvM1.setOnAction(e->{
//			if(isValid(1)) {
////				moveIndex[1] = Main.getTurn() ? 1 : 2;
////				Main.setTurn();
////				Game.setGameState(moveIndex);
//				move = 1;
//			}
//			else {
//				start.close();
//			}
//			//start.setScene(updateBoard());
//		});
//		Button PvM2 = new Button("Location 2");
//		PvM2.setOnAction(e->{
//			if(isValid(2)) {
////				moveIndex[2] = Main.getTurn() ? 1 : 2;
////				Main.setTurn();
////				Game.setGameState(moveIndex);
//				move = 2;
//			}
//			else {
//				start.close();
//			}
//			//start.setScene(updateBoard());
//		});
//		Button PvM3 = new Button("Location 3");
//		PvM3.setOnAction(e->{
//			if(isValid(3)) {
////				moveIndex[3] = Main.getTurn() ? 1 : 2;
////				Main.setTurn();
////				Game.setGameState(moveIndex);
//				move = 3;
//			}
//			else {
//				start.close();
//			}
//			//start.setScene(updateBoard());
//		});
//		Button PvM4 = new Button("Location 4");
//		PvM4.setOnAction(e->{
//			if(isValid(4)) {
////				moveIndex[4] = Main.getTurn() ? 1 : 2;
////				Main.setTurn();
////				Game.setGameState(moveIndex);
//				move = 4;
//			}
//			else {
//				start.close();
//			}
//			start.setScene(updateBoard());
//		});
//		Button PvM5 = new Button("Location 5");
//		PvM5.setOnAction(e->{
//			if(isValid(5)) {
////				moveIndex[5] = Main.getTurn() ? 1 : 2;
////				Main.setTurn();
////				Game.setGameState(moveIndex);
//				move = 5;
//			}
//			else {
//				start.close();
//			}
//			//start.setScene(updateBoard());
//		});
//		Button PvM6 = new Button("Location 6");
//		PvM6.setOnAction(e->{
//			if(isValid(6)) {
////				moveIndex[6] = Main.getTurn() ? 1 : 2;
////				Main.setTurn();
////				Game.setGameState(moveIndex);
//				move = 6;
//			}
//			else {
//				start.close();
//			}
//			//start.setScene(updateBoard());
//		});
//		Button PvM7 = new Button("Location 7");
//		PvM7.setOnAction(e->{
//			if(isValid(7)) {
////				moveIndex[7] = Main.getTurn() ? 1 : 2;
////				Main.setTurn();
////				Game.setGameState(moveIndex);
//				move = 7;
//			}
//			else {
//				start.close();
//			}
//			//start.setScene(updateBoard());
//		});
//		Button PvM8 = new Button("Location 8");
//		PvM8.setOnAction(e->{
//			if(isValid(8)) {
////				moveIndex[8] = Main.getTurn() ? 1 : 2;
////				Main.setTurn();
////				Game.setGameState(moveIndex);
//				move = 8;
//			}
//			else {
//				start.close();
//			}
//			//start.setScene(updateBoard());
//		});
		/*Button win = new Button("Click to Win");
		win.setOnAction(e->{
			playerWins = playerWins + 1;
			start.setScene(winScreen());
		});*/
		Button lose = new Button("Click to Lose");
		lose.setOnAction(e->{
			machineWins = machineWins + 1;
			start.setScene(loseScreen());
		});
		Button tie = new Button("Click to tie");
		tie.setOnAction(e->{
			numTies = numTies + 1;
			start.setScene(tieScreen());
		});
		Text pvmText = new Text("Player vs Machine");
		HBox pvmHBox = new HBox(20);
		pvmHBox.getChildren().addAll(lose, tie);
		JFrame pvm = new JFrame("TicTacToeLayout");
		pvm.add(PvM0);
		pvm.add(PvM1);
		pvm.add(PvM2);
		pvm.add(PvM3);
		pvm.add(PvM4);
		pvm.add(PvM5);
		pvm.add(PvM6);
		pvm.add(PvM7);
		pvm.add(PvM8);
		pvm.setLayout(new GridLayout(3,3));
		pvm.setSize(300,300);
		pvm.setVisible(true);
//		pvm1.getChildren().addAll(PvM0, PvM1, PvM2);
//		HBox pvm2 = new HBox(10);
//		pvm2.getChildren().addAll(PvM3, PvM4, PvM5);
//		HBox pvm3 = new HBox(10);
//		pvm3.getChildren().addAll(PvM6, PvM7, PvM8);
//		VBox pvmBoard = new VBox(10);
//		pvmBoard.getChildren().addAll(pvm1, pvm2, pvm3);
//		VBox pvmDisplay = new VBox(20);
//		pvmDisplay.getChildren().addAll(pvmText, pvmBoard, pvmHBox);
		
		GridPane board = new GridPane();
		GridPane.setConstraints(board, 2, 2);

		Rectangle border0 = new Rectangle(200, 200);
		border0.setFill(null);
		border0.setStroke(Color.BLACK);

		Rectangle border1 = new Rectangle(200, 200);
		border1.setFill(null);
		border1.setStroke(Color.BLACK);

		Rectangle border2 = new Rectangle(200, 200);
		border2.setFill(null);
		border2.setStroke(Color.BLACK);

		Rectangle border3 = new Rectangle(200, 200);
		border3.setFill(null);
		border3.setStroke(Color.BLACK);

		Rectangle border4 = new Rectangle(200, 200);
		border4.setFill(null);
		border4.setStroke(Color.BLACK);

		Rectangle border5 = new Rectangle(200, 200);
		border5.setFill(null);
		border5.setStroke(Color.BLACK);

		Rectangle border6 = new Rectangle(200, 200);
		border6.setFill(null);
		border6.setStroke(Color.BLACK);

		Rectangle border7 = new Rectangle(200, 200);
		border7.setFill(null);
		border7.setStroke(Color.BLACK);

		Rectangle border8 = new Rectangle(200, 200);
		border8.setFill(null);
		border8.setStroke(Color.BLACK);

		board.add(border0, 0, 0);
		board.add(border1, 1, 0);
		board.add(border2, 2, 0);
		board.add(border3, 0, 1);
		board.add(border4, 1, 1);
		board.add(border5, 2, 1);
		board.add(border6, 0, 2);
		board.add(border7, 1, 2);
		board.add(border8, 2, 2);
		HBox pvmDisplay1 = new HBox(30);
		pvmDisplay1.getChildren().addAll(board);
		Scene scene = new Scene(pvmDisplay1, 1000, 800);
		return scene;
	}
	
	public static Scene updateBoard() {
		Game.printGameState();
		for(int i = 0; i < 9; i++) {
			moveIndex[i] = Game.getGameState()[i];
		}
		Button PvM0 = new Button("Location 0");
		PvM0.setOnAction(e->{
			if(isValid(0)) {
				//moveIndex[0] = Main.getTurn() ? 1 : 2;
				//Main.setTurn();
				//Game.setGameState(moveIndex);
				//Game.printGameState();
				move = 0;
			}
			else {
				start.close();
			}
			//start.setScene(updateBoard());
		});
		Button PvM1 = new Button("Location 1");
		PvM1.setOnAction(e->{
			if(isValid(1)) {
				//moveIndex[1] = Main.getTurn() ? 1 : 2;
				//Main.setTurn();
				//Game.setGameState(moveIndex);
				//Game.printGameState();
				move = 1;
			}
			else {
				start.close();
			}
			//start.setScene(updateBoard());
		});
		Button PvM2 = new Button("Location 2");
		PvM2.setOnAction(e->{
			if(isValid(2)) {
//				moveIndex[2] = Main.getTurn() ? 1 : 2;
//				Main.setTurn();
//				Game.setGameState(moveIndex);
//				Game.printGameState();
				move = 2;
			}
			else {
				start.close();
			}
			//start.setScene(updateBoard());
		});
		Button PvM3 = new Button("Location 3");
		PvM3.setOnAction(e->{
			if(isValid(3)) {
//				moveIndex[3] = Main.getTurn() ? 1 : 2;
//				Main.setTurn();
//				Game.setGameState(moveIndex);
//				Game.printGameState();
				move = 3;
			}
			else {
				start.close();
			}
			//start.setScene(updateBoard());
		});
		Button PvM4 = new Button("Location 4");
		PvM4.setOnAction(e->{
			if(isValid(4)) {
//				moveIndex[4] = Main.getTurn() ? 1 : 2;
//				Main.setTurn();
//				Game.setGameState(moveIndex);
//				Game.printGameState();
				move = 4;
			}
			else {
				start.close();
			}
			//start.setScene(updateBoard());
		});
		Button PvM5 = new Button("Location 5");
		PvM5.setOnAction(e->{
			if(isValid(5)) {
//				moveIndex[5] = Main.getTurn() ? 1 : 2;
//				Main.setTurn();
//				Game.setGameState(moveIndex);
//				Game.printGameState();
				move = 5;
			}
			else {
				start.close();
			}
			//start.setScene(updateBoard());
		});
		Button PvM6 = new Button("Location 6");
		PvM6.setOnAction(e->{
			if(isValid(6)) {
//				moveIndex[6] = Main.getTurn() ? 1 : 2;
//				Main.setTurn();
//				Game.setGameState(moveIndex);
//				Game.printGameState();
				move = 6;
			}
			else {
				start.close();
			}
			//start.setScene(updateBoard());
		});
		Button PvM7 = new Button("Location 7");
		PvM7.setOnAction(e->{
			if(isValid(7)) {
//				moveIndex[7] = Main.getTurn() ? 1 : 2;
//				Main.setTurn();
//				Game.setGameState(moveIndex);
//				Game.printGameState();
				move = 7;
			}
			else {
				start.close();
			}
			//start.setScene(updateBoard());
		});
		Button PvM8 = new Button("Location 8");
		PvM8.setOnAction(e->{
			if(isValid(8)) {
//				moveIndex[8] = Main.getTurn() ? 1 : 2;
//				Main.setTurn();
//				Game.setGameState(moveIndex);
//				Game.printGameState();
				move = 8;
			}
			else {
				start.close();
			}
			//start.setScene(updateBoard());
		});
		/*Button win = new Button("Click to Win");
		win.setOnAction(e->{
			playerWins = playerWins + 1;
			start.setScene(winScreen());
		});*/
		Button lose = new Button("Click to Lose");
		lose.setOnAction(e->{
			machineWins = machineWins + 1;
			start.setScene(loseScreen());
		});
		Button tie = new Button("Click to tie");
		tie.setOnAction(e->{
			numTies = numTies + 1;
			start.setScene(tieScreen());
		});
		Text pvmText = new Text("Player vs Machine");
		HBox pvmHBox = new HBox(20);
		pvmHBox.getChildren().addAll(lose, tie);
		HBox pvm1 = new HBox(10);
		pvm1.getChildren().addAll(PvM0, PvM1, PvM2);
		HBox pvm2 = new HBox(10);
		pvm2.getChildren().addAll(PvM3, PvM4, PvM5);
		HBox pvm3 = new HBox(10);
		pvm3.getChildren().addAll(PvM6, PvM7, PvM8);
		VBox pvmBoard = new VBox(10);
		pvmBoard.getChildren().addAll(pvm1, pvm2, pvm3);
		VBox pvmDisplay = new VBox(20);
		pvmDisplay.getChildren().addAll(pvmText, pvmBoard, pvmHBox);
		
		GridPane board = new GridPane();
		GridPane.setConstraints(board, 2, 2);

		Rectangle border0 = new Rectangle(200, 200);
		border0.setFill(null);
		border0.setStroke(Color.BLACK);
		Text text0 = xOOrBlank(moveIndex[0]);
		StackPane bord0 = new StackPane();
		bord0.getChildren().addAll(border0, text0);

		Rectangle border1 = new Rectangle(200, 200);
		border1.setFill(null);
		border1.setStroke(Color.BLACK);
		Text text1 = xOOrBlank(moveIndex[1]);
		StackPane bord1 = new StackPane();
		bord1.getChildren().addAll(border1, text1);

		Rectangle border2 = new Rectangle(200, 200);
		border2.setFill(null);
		border2.setStroke(Color.BLACK);
		Text text2 = xOOrBlank(moveIndex[2]);
		StackPane bord2 = new StackPane();
		bord2.getChildren().addAll(border2, text2);

		Rectangle border3 = new Rectangle(200, 200);
		border3.setFill(null);
		border3.setStroke(Color.BLACK);
		Text text3 = xOOrBlank(moveIndex[3]);
		StackPane bord3 = new StackPane();
		bord3.getChildren().addAll(border3, text3);

		Rectangle border4 = new Rectangle(200, 200);
		border4.setFill(null);
		border4.setStroke(Color.BLACK);
		Text text4 = xOOrBlank(moveIndex[4]);
		StackPane bord4 = new StackPane();
		bord4.getChildren().addAll(border4, text4);

		Rectangle border5 = new Rectangle(200, 200);
		border5.setFill(null);
		border5.setStroke(Color.BLACK);
		Text text5 = xOOrBlank(moveIndex[5]);
		StackPane bord5 = new StackPane();
		bord5.getChildren().addAll(border5, text5);

		Rectangle border6 = new Rectangle(200, 200);
		border6.setFill(null);
		border6.setStroke(Color.BLACK);
		Text text6 = xOOrBlank(moveIndex[6]);
		StackPane bord6 = new StackPane();
		bord6.getChildren().addAll(border6, text6);

		Rectangle border7 = new Rectangle(200, 200);
		border7.setFill(null);
		border7.setStroke(Color.BLACK);
		Text text7 = xOOrBlank(moveIndex[7]);
		StackPane bord7 = new StackPane();
		bord7.getChildren().addAll(border7, text7);

		Rectangle border8 = new Rectangle(200, 200);
		border8.setFill(null);
		border8.setStroke(Color.BLACK);
		Text text8 = xOOrBlank(moveIndex[8]);
		StackPane bord8 = new StackPane();
		bord8.getChildren().addAll(border8, text8);

		board.add(bord0, 0, 0);
		board.add(bord1, 1, 0);
		board.add(bord2, 2, 0);
		board.add(bord3, 0, 1);
		board.add(bord4, 1, 1);
		board.add(bord5, 2, 1);
		board.add(bord6, 0, 2);
		board.add(bord7, 1, 2);
		board.add(bord8, 2, 2);
		HBox pvmDisplay1 = new HBox(30);
		pvmDisplay1.getChildren().addAll(pvmDisplay, board);
		PvM = new Scene(pvmDisplay1, 1000, 800);
		return PvM;
	}
	
	public static Scene tieScreen() {
		Text loseText = new Text("Unfortunately You have Lost");
		Text scoreText = new Text("Current Score");
		Text playerWin = new Text("Player: " + String.valueOf(playerWins));
		Text machineWin = new Text("Machine: " + String.valueOf(machineWins));
		Text ties = new Text("Total Ties: " + String.valueOf(numTies));
		Text playAgain = new Text("Would you like to play again?");
		Button yesAgain = new Button("Yes");
		yesAgain.setOnAction(e-> start.setScene(PvM));
		Button noAgain = new Button("No");
		noAgain.setOnAction(e->{ 
			start.close();
			System.exit(1);
			});
		HBox choiceHBox = new HBox(20);
		choiceHBox.getChildren().addAll(yesAgain, noAgain);
		VBox loseVBox = new VBox(10);
		loseVBox.getChildren().addAll(loseText, scoreText, playerWin, machineWin, ties, playAgain, choiceHBox);
		Scene loseScreen = new Scene(loseVBox, 800, 800);
		return loseScreen;
	}
	
	public static Scene winScreen(int moveNumber) {
		Text winText;
		if(moveNumber == 1) {
			winText = new Text("Congradulations Player X, You have Won");
		}
		else {
			winText = new Text("Congradulations Player O, You have Won");
		}
		Text scoreText = new Text("Current Score");
		Text playerWin = new Text("Player: " + String.valueOf(playerWins));
		Text machineWin = new Text("Machine: " + String.valueOf(machineWins));
		Text ties = new Text("Total Ties: " + String.valueOf(numTies));
		Text playAgain = new Text("Would you like to play again?");
		Button yesAgain = new Button("Yes");
		yesAgain.setOnAction(e->{ 
			PvM = resetBoard();
			start.setScene(PvM);
		});
		Button noAgain = new Button("No");
		noAgain.setOnAction(e-> start.close());
		HBox choiceHBox = new HBox(20);
		choiceHBox.getChildren().addAll(yesAgain, noAgain);
		VBox winVBox = new VBox(10);
		winVBox.getChildren().addAll(winText, scoreText, playerWin, machineWin, ties, playAgain, choiceHBox);
		Scene winScreen = new Scene(winVBox, 800, 800);
		return winScreen;
	}
	
	public static Scene loseScreen() {
		Text loseText = new Text("Unfortunately You have Lost");
		Text scoreText = new Text("Current Score");
		Text playerWin = new Text("Player: " + String.valueOf(playerWins));
		Text machineWin = new Text("Machine: " + String.valueOf(machineWins));
		Text ties = new Text("Total Ties: " + String.valueOf(numTies));
		Text playAgain = new Text("Would you like to play again?");
		Button yesAgain = new Button("Yes");
		yesAgain.setOnAction(e-> {
			PvM = resetBoard();
			start.setScene(PvM);
		});
		Button noAgain = new Button("No");
		noAgain.setOnAction(e-> start.close());
		Button choiceHome = new Button("Home");
		choiceHome.setOnAction(e-> homeScreen());
		HBox choiceHBox = new HBox(20);
		choiceHBox.getChildren().addAll(yesAgain, noAgain);
		VBox loseVBox = new VBox(10);
		loseVBox.getChildren().addAll(loseText, scoreText, playerWin, machineWin, ties, playAgain, choiceHBox, choiceHome);
		Scene loseScreen = new Scene(loseVBox, 800, 800);
		return loseScreen;
	}
	
	public static void homeScreen() {
		Text startText1 = new Text("Welcome to Tic Tac Toe");
		Text startText2 = new Text("Please Chose Player vs Player or Player vs Machine");
		Button playerVsPlayer = new Button("Player vs Player");
		playerVsPlayer.setOnAction(e->{ 
			start.setScene(PvP);
			System.out.println("You have selected PvP");
			Game.resetGameState();
			//Main.playGame(true, false);
		});
		Button playerVsMachine = new Button("Player vs Machine");
		playerVsMachine.setOnAction(e->{
			start.setScene(PvM);
			System.out.println("You have selected PvM");
			Game.resetGameState();
			//Main.playGame(true, false);
		});
		HBox startHBox = new HBox(20);
		startHBox.getChildren().addAll(playerVsPlayer, playerVsMachine);
		VBox startVBox = new VBox(10);
		startVBox.getChildren().addAll(startText1, startText2, startHBox);
		Scene origin = new Scene(startVBox, 400, 400);
		
		//PvM Screen Stuff
		PvP = resetBoard();
		PvM = resetBoard();
		start.setScene(origin);
	
	}
	
	public void start(Stage primaryStage) throws Exception{
		start = primaryStage;
		
		//Initial Stage Stuff
		
		homeScreen();
		start.setTitle("TicTacToe");
		start.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(java.awt.event.ActionEvent e) {
			if(e.getSource() == PvM0) {
				move = 0;
			}
			if(e.getSource() == PvM1) {
				move = 1;
			}
			if(e.getSource() == PvM2) {
				move = 2;
			}
			if(e.getSource() == PvM3) {
				move = 3;
			}
			if(e.getSource() == PvM4) {
				move = 4;
			}
			if(e.getSource() == PvM5) {
				move = 5;
			}
			if(e.getSource() == PvM6) {
				move = 6;
			}
			if(e.getSource() == PvM7) {
				move = 7;
			}
			if(e.getSource() == PvM8) {
				move = 8;
			}
		}
		
	}
}
