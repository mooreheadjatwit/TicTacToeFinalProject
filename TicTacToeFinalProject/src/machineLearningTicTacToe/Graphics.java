package machineLearningTicTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Graphics extends Application {

	Stage window;
	Scene start, game, victory, loss;

	private boolean TurnX = true;
	private int[] array = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	private Text shape = new Text();

	public boolean isFull(int n) {
	
		return (n == 0) ? true:false;
	}

	public Text xOorblank(int n) {

		int state = n;
		Text xText = new Text("X");
		Text oText = new Text("O");
		Text blankText = new Text(" ");

		xText.setStyle("-fx-font: 50 arial;");
		oText.setStyle("-fx-font: 50 arial;");
		blankText.setStyle("-fx-font: 50 arial;");

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		///////////////////////// create GridPane below/////////////////////////////////
		
		GridPane startBox = new GridPane();
		GridPane.setConstraints(startBox, 0, 1);

		//////////////////////// create greeting below///////////////////////////////
		Text hello = new Text("welcome to tic tac toe");
		hello.setFont(Font.font(50));

		////////////////////////// create button below////////////////////////////////
		Button change = new Button("Click to go to scene 2");
		change.setOnAction(e -> window.setScene(game));

		///////////////////////// set gridPane/////////////////////////////////////////
		startBox.add(hello, 0, 0);
		startBox.add(change, 0, 1);

		//////////////////////// create scene///////////////////////////////////
		start = new Scene(startBox, 600, 600);

		BorderPane secondScene = new BorderPane();
		game = new Scene(secondScene, 600, 600);

/////////////////////////////////////////////////////Start Scene Above//////////////		

/////////////////////////////////////////////////////Controls Below/////////////		

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

		


		
////////////////////////////////////////////////Controls Above////////////////

////////////////////////////////////////////////Board View Below//////////////

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

		secondScene.setCenter(board);

////////////////////////////////////////////////Board View Above/////////////////////	

///////////////////////////////////////////////Board Event Handling Below///////////

		btn1.setOnAction(e -> {

			if (TurnX == true && isFull(array[0]) == true) {
				array[0] = 1;

				board.add(xOorblank(array[0]), 0, 0);
				TurnX = false;
			} else if(isFull(array[0]) == true){
				array[0] = 2;
				board.add(xOorblank(array[0]), 0, 0);
				TurnX = true;
			}

		});

		btn2.setOnAction(e -> {

			if (TurnX == true && isFull(array[1]) == true) {
				array[1] = 1;
				board.add(xOorblank(array[1]), 1, 0);
				TurnX = false;
			} else if( isFull(array[1]) == true){
				array[1] = 2;
				board.add(xOorblank(array[1]), 1, 0);
				TurnX = true;
			}

		});

		btn3.setOnAction(e -> {

			if (TurnX == true && isFull(array[2]) == true) {
				array[2] = 1;
				board.add(xOorblank(array[2]), 2, 0);
				TurnX = false;
			} else if(isFull(array[2]) == true){
				array[2] = 2;
				board.add(xOorblank(array[2]), 2, 0);
				TurnX = true;
			}

		});

		btn4.setOnAction(e -> {

			if (TurnX == true && isFull(array[3]) == true) {
				array[3] = 1;
				board.add(xOorblank(array[3]), 0, 1);
				TurnX = false;
			} else if(isFull(array[3]) == true){
				array[3] = 2;
				board.add(xOorblank(array[3]), 0, 1);
				TurnX = true;
			}

		});

		btn5.setOnAction(e -> {

			if (TurnX == true && isFull(array[4]) == true) {
				array[4] = 1;
				board.add(xOorblank(array[4]), 1, 1);
				TurnX = false;
			} else if( isFull(array[4]) == true){
				array[4] = 2;
				board.add(xOorblank(array[4]), 1, 1);
				TurnX = true;
			}

		});

		btn6.setOnAction(e -> {

			if (TurnX == true && isFull(array[5]) == true) {
				array[5] = 1;
				board.add(xOorblank(array[5]), 2, 1);
				TurnX = false;
			} else if(isFull(array[5]) == true){
				array[5] = 2;
				board.add(xOorblank(array[5]), 2, 1);
				TurnX = true;
			}

		});

		btn7.setOnAction(e -> {

			if (TurnX == true && isFull(array[6]) == true) {
				array[6] = 1;
				board.add(xOorblank(array[6]), 0, 2);
				TurnX = false;
				
			} else if(isFull(array[6]) == true){
				array[6] = 2;
				board.add(xOorblank(array[6]), 0, 2);
				TurnX = true;
			}

		});

		btn8.setOnAction(e -> {

			if (TurnX == true && isFull(array[7]) == true) {
				array[7] = 1;
				board.add(xOorblank(array[7]), 1, 2);
				TurnX = false;
			} else if( isFull(array[7]) == true){
				array[7] = 2;
				board.add(xOorblank(array[7]), 1, 2);
				TurnX = true;
			}

		});

		btn9.setOnAction(e -> {

			if (TurnX == true && isFull(array[8]) == true) {
				array[8] = 1;
				board.add(xOorblank(array[8]), 2, 2);
				TurnX = false;
			} else if( isFull(array[8]) == true){
				array[8] = 2;
				board.add(xOorblank(array[8]), 2, 2);
				TurnX = true;
			}

		});

//		int zeroCount = 0;
//		
//		for(int i = 0; i < array.length; i++) {
//			if(array[i] == 0) {
//				zeroCount++;
//				
//			}	
//		}
//		if(zeroCount == 0) {
//			//set game over
//		}

//////////////////////////////////////////////////Board Event Handling Above////////////

		window.setScene(start);
		window.setTitle("TicTacToe");
		window.show();

	}
}
