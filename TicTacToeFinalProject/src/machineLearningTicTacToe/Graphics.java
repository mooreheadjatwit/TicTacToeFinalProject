package machineLearningTicTacToe;


import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Graphics extends Application {
	static boolean Replay = false;
	static int index;
	Stage window;
	static Scene start;
	Scene game;
	Scene victory;
	Scene loss;

	private boolean TurnX = true;
	private int[] moveIndex = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	private Text shape = new Text();

	public boolean isFull(int n) {
	
		return (n == 0) ? true:false;
	}

	
//////////////////////////////////////////////////Initial Display below
	public static boolean initialDisplay() {
		
		
		
		
		
		
		int [] bool = new int[2];
		 
		 
		GridPane startBox = new GridPane();
		GridPane.setConstraints(startBox, 1, 1);
		start= new Scene(startBox,600,600);

		//////////////////////// create greeting below///////////////////////////////
		Text hello = new Text("welcome to tic tac toe");
		hello.setFont(Font.font(50));

		////////////////////////// create button below////////////////////////////////
		Button PvP = new Button("pvp");
		Button PvM = new Button("pvm");
		PvP.setOnAction(e -> {
			bool[0] = 1;
			
			
		});
		PvM.setOnAction(e -> {
			
			bool[1] = 1;
			
		});

		///////////////////////// set gridPane/////////////////////////////////////////
		startBox.add(hello, 0, 0);
		startBox.add(PvP, 0, 1);
		startBox.add(PvM, 1, 1);

	
		
		
		return (bool[0] == 1) ? true:false;

	
		
		
		// create new button for pvm 
		
		
		
		
	}
	

	
	
	//////////////////////Victory screen below
	
	public static boolean victoryScreen () {
		
		
		
		BorderPane vicPane = new BorderPane();
		Text vicText = new Text("congrats, you have won!");
		
		vicPane.setAlignment(vicText, Pos.TOP_CENTER);
			
		Button replay = new Button("Press to replay Tic Tac Toe");
		
		vicPane.setAlignment(replay, Pos.BASELINE_CENTER);
		
		
			replay.setOnAction(e -> {
				
				Replay = true;
				
			});
		
		
		
		return Replay;
			
	}
	
	
public static boolean lossScreen () {
		
		
		
		BorderPane vicPane = new BorderPane();
		Text vicText = new Text("Unfortunatly, you have lost!");
		
		vicPane.setAlignment(vicText, Pos.TOP_CENTER);
			
		Button replay = new Button("Press to replay Tic Tac Toe");
		
		vicPane.setAlignment(replay, Pos.BASELINE_CENTER);
		
		
			replay.setOnAction(e -> {
				
				Replay = true;
				
			});
		
		
		
		return Replay;
			
	}
	
	
	
	
	
	
	
	
	
	
	// not needed
	public Text xOorblank(int n) {
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

		} else {
			return blankText;
		}

	}
//////////////////////////////////////////////////Main Method////////
	public static void main(String[] args) {
		
		
		
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
	
////////////////////////////////////////////////Victory View Below//////////////

BorderPane victoryScreen = new BorderPane();
Text vText = new Text("You Have Won!");
victoryScreen.setAlignment(vText, Pos.TOP_CENTER);

Button replay = new Button("Press to replay");

victoryScreen.setAlignment(replay, Pos.TOP_CENTER);

replay.setOnAction(e -> {

	window.setScene(game);

});

victory = new Scene(victoryScreen,600,600);






///////////////////////////////////////////////////////////////////////////////////////


BorderPane lossScreen = new BorderPane();
Text lText = new Text("You Have Lost!");
lossScreen.setAlignment(lText, Pos.TOP_CENTER);

Button replay2 = new Button("Press to replay");

lossScreen.setAlignment(replay2, Pos.TOP_CENTER);

replay2.setOnAction(e -> {

	window.setScene(game);

});

loss = new Scene(victoryScreen,600,600);







		window.setScene((start));
		window.setTitle("TicTacToe");
		window.show();

	}


	public static int boardDisplay(int[] moveIndex) {
	////////////
		//TEMP PRINT METHOD 
		//////////////////////
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		Game.printGameState();
		System.out.println("Player 1 chose your move");
		boolean valid = false;
		int index = -1;
		while(!valid) {
			index = s.nextInt();
			if(index >= 0 && index < 9 && moveIndex[index] == 0 ) {
				valid = true;
			} else {
				System.out.println("Please enter an availible index [0-8]");
			}
		}
		
		///////////////////////////
		//END TEMP PRINT METHOD
		///////////////////////////
		/*
		BorderPane secondScene = new BorderPane();
		Scene game = new Scene(secondScene, 600, 600);
		
		GridPane controls = new GridPane();
		GridPane.setConstraints(controls, 2, 2);
		controls.setAlignment(Pos.BASELINE_CENTER);

		final Button btn1 = new Button("Pos UL");
		final Button btn2 = new Button("Pos UM");
		final Button btn3 = new Button("Pos UR");

		final Button btn4 = new Button("Pos ML");
		final Button btn5 = new Button("Pos MM");
		final Button btn6 = new Button("Pos MR");

		final Button btn7 = new Button("Pos BL");
		final Button btn8 = new Button("Pos BM");
		final Button btn9 = new Button("Pos BR");

		controls.add(btn1, 0, 0);
		controls.add(btn2, 1, 0);
		controls.add(btn3, 2, 0);
		controls.add(btn4, 0, 1);
		controls.add(btn5, 1, 1);
		controls.add(btn6, 2, 1);
		controls.add(btn7, 0, 2);
		controls.add(btn8, 1, 2);
		controls.add(btn9, 2, 2);
		secondScene.setLeft(controls);
		
		
		//int index = 0;
		btn1.setOnAction(e -> {

			if (moveIndex[0] == 0) {
				index = 0;
			} else {

			}

			
			
		});

		btn2.setOnAction(e -> {

			if (moveIndex[1] == 0) {
				
				index = 1;
			
			} else {
				
				
			}

		});

		btn3.setOnAction(e -> {

			if (moveIndex[2] == 0) {
				
				index = 2;
			
			} else {
				
				
			}

		});

		btn4.setOnAction(e -> {

			if (moveIndex[3] == 0) {
				
				index = 3;
			
			} else {
				
				
			
			}

		});

		btn5.setOnAction(e -> {

			if (moveIndex[4] == 0) {
				
				index = 4;
				
			} else {
				
			}

		});

		btn6.setOnAction(e -> {

			if (moveIndex[5] == 0) {
				
				index = 5;
				
			} else {
				
			}

		});

		btn7.setOnAction(e -> {

			if (moveIndex[6] == 0) {
				
				index = 6;
				
				
			} else{
				
			}

		});

		btn8.setOnAction(e -> {

			if (moveIndex[7] == 0) {
				
				index = 7;
				
			} else {
				
			
			}

		});

		btn9.setOnAction(e -> {

			if (moveIndex[8] == 0) {
				
				index = 8;
				
			} else {
				
				
				
			}
			
		});

		
		GridPane board = new GridPane();
		GridPane.setConstraints(board, 2, 2);

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

		Rectangle border9 = new Rectangle(200, 200);
		border9.setFill(null);
		border9.setStroke(Color.BLACK);

		board.add(border1, 0, 0);
		board.add(border2, 1, 0);
		board.add(border3, 2, 0);
		board.add(border4, 0, 1);
		board.add(border5, 1, 1);
		board.add(border6, 2, 1);
		board.add(border7, 0, 2);
		board.add(border8, 1, 2);
		board.add(border9, 2, 2);

		*/
		return index;	
		
		
	
	}


	public static void tieScreen() {
		// TODO replace with graphical method
		System.out.println("It'sa tie!");
		
	}
}
