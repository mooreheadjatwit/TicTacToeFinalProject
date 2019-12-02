package machineLearningTicTacToe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BoardDisplay extends Application{
static Scene game;
static int index;
private boolean TurnX = true;
private static int[] moveIndex = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };


	public int main(String[] args) {
		moveIndex = Game.getGameState();
		try {
			start(Main.window);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return index;
		
	}

	public void start(Stage primaryStage) throws Exception {
		
		BorderPane secondScene = new BorderPane();
		
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
				primaryStage.close();
			} else {

			}

			
			
		});

		btn2.setOnAction(e -> {

			if (moveIndex[1] == 0) {
				
				index = 1;
				primaryStage.close();

			
			} else {
				
				
			}

		});

		btn3.setOnAction(e -> {

			if (moveIndex[2] == 0) {
				
				index = 2;
				primaryStage.close();

			
			} else {
				
				
			}

		});

		btn4.setOnAction(e -> {

			if (moveIndex[3] == 0) {
				
				index = 3;
				primaryStage.close();

			
			} else {
				
				
			
			}

		});

		btn5.setOnAction(e -> {

			if (moveIndex[4] == 0) {
				
				index = 4;
				primaryStage.close();

				
			} else {
				
			}

		});

		btn6.setOnAction(e -> {

			if (moveIndex[5] == 0) {
				
				index = 5;
				primaryStage.close();

				
			} else {
				
			}

		});

		btn7.setOnAction(e -> {

			if (moveIndex[6] == 0) {
				
				index = 6;
				primaryStage.close();

				
				
			} else{
				
			}

		});

		btn8.setOnAction(e -> {

			if (moveIndex[7] == 0) {
				
				index = 7;
				primaryStage.close();

				
			} else {
				
			
			}

		});

		btn9.setOnAction(e -> {

			if (moveIndex[8] == 0) {
				
				index = 8;
				primaryStage.close();

				
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

		
		secondScene.setCenter(board);
		
		Scene game = new Scene(secondScene, 600, 600);
		
		
		primaryStage.setTitle("TicTacToe");
		primaryStage.setScene(game);
		primaryStage.show();
		
	}

}
