package machineLearningTicTacToe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LossScreen extends Application{
static Scene loss;
	
	
	public static void main(String[] args) {

       launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane lossScreen = new BorderPane();
		Text lText = new Text("You Have Lost!");
		lossScreen.setTop(lText);

		Button replay2 = new Button("Press to replay");
		lossScreen.setBottom(replay2);

		lossScreen.setAlignment(replay2, Pos.TOP_CENTER);

		replay2.setOnAction(e -> {

		

		});

		loss = new Scene(lossScreen,600,600);
		
		primaryStage.setTitle("TicTacToe");
		primaryStage.setScene(loss);
		primaryStage.show();
		
		
		
	}

}
