package machineLearningTicTacToe;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InitialDisplay extends Application {
	
	private Parent initialDisplay() {
		StackPane first = new StackPane();
		first.setPrefSize(600, 600);
		Text Hello = new Text("Welcome to TicTacToe. select PVP or PVM");
		
		Hello.setFont(Font.font(72));
		first.getChildren().add(Hello);
		return first;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		primaryStage.setTitle("TicTacToe");
		primaryStage.setScene(new Scene(initialDisplay()));
		primaryStage.show();
		
	}

}
