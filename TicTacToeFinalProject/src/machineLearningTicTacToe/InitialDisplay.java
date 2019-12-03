package machineLearningTicTacToe;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InitialDisplay extends Application {
	
	
	
	static Scene start;
	private static boolean pvp = false;
	private Parent initialDisplay() {
		StackPane first = new StackPane();
		first.setPrefSize(600, 600);
		Text Hello = new Text("Welcome to TicTacToe. select PVP or PVM");
		
		Hello.setFont(Font.font(72));
		first.getChildren().add(Hello);
		return first;
		
	}

	public static boolean main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		return pvp;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		int [] bool = new int[2];
		 
		 
		GridPane startBox = new GridPane();
		GridPane.setConstraints(startBox, 1, 1);
		Scene start = new Scene(startBox,600,600);

		//////////////////////// create greeting below///////////////////////////////
		Text hello = new Text("welcome to tic tac toe");
		hello.setFont(Font.font(50));

		////////////////////////// create button below////////////////////////////////
		Button PvP = new Button("pvp");
		Button PvM = new Button("pvm");
		PvP.setOnAction(e -> {
			pvp = true;
			//InitialDisplay.main();
			
		});
		PvM.setOnAction(e -> {
			
			pvp = false;
			primaryStage.close();
			
		});

		///////////////////////// set gridPane/////////////////////////////////////////
		startBox.add(hello, 0, 0);
		startBox.add(PvP, 0, 1);
		startBox.add(PvM, 1, 1);

		primaryStage.setScene(start);
		primaryStage.setTitle("TicTacToe");
		primaryStage.show();
		
	
		
		
		// create new button for pvm 
		
		
		
		
	}

}
