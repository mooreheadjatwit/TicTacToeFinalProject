package machineLearningTicTacToe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TieScreen extends Application{
static Scene tie;
	public static void main(String[] args) {
	launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane tieScreen = new BorderPane();
		Text lText = new Text("You Have tied!");
		tieScreen.setTop(lText);

		Button replay3 = new Button("Press to replay");
		tieScreen.setBottom(replay3);

		tieScreen.setAlignment(replay3, Pos.TOP_CENTER);

		replay3.setOnAction(e -> {

		

		});

		tie = new Scene(tieScreen,600,600);
		
		primaryStage.setTitle("TicTacToe");
		primaryStage.setScene(tie);
		primaryStage.show();
		
		
		
	}

}
