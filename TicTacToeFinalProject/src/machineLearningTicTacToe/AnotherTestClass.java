package machineLearningTicTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AnotherTestClass extends Application {
	Stage window;
	Scene start, playerGame, machineGame, victory, loss;
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		GridPane startBox = new GridPane();
		GridPane.setConstraints(startBox, 0, 1);
		
		Text begin = new Text("Welcome to Tic Tac Toe");
		begin.setFont(Font.font(50));
		
		Button pvp = new Button("Player vs Player");
		pvp.setOnAction(e -> window.setScene(playerGame));
		
		Button pvm = new Button("Player vs Machine");
		pvm.setOnAction(e -> window.setScene(machineGame));
		
		startBox.add(begin, 0, 0);
		startBox.add(pvp, 0, 1);
		startBox.add(pvm, 0, 2);
		
		start = new Scene(startBox, 600, 600);
		
		BorderPane secondScene = new BorderPane();
		playerGame = new Scene(secondScene, 600, 600);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
