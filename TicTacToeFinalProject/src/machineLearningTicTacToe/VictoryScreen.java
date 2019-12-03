package machineLearningTicTacToe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VictoryScreen extends Application{
	private boolean restart = false;
	Scene victory;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane victoryScreen = new BorderPane();
		Text vText = new Text("You Have Won!");
		
		victoryScreen.setTop(vText);

		Button replayB = new Button("Press to replay");
		victoryScreen.setBottom(replayB);
		victoryScreen.setAlignment(replayB, Pos.TOP_CENTER);

		replayB.setOnAction(e -> {

			restart = true;

		});

		victory = new Scene(victoryScreen,600,600);
		
		primaryStage.setTitle("TicTacToe");
		primaryStage.setScene(victory);
		primaryStage.show();

		
		
	}

}
