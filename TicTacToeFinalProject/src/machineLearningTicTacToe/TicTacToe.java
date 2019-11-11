package machineLearningTicTacToe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class TicTacToe extends Application {
	
	
Stage window;
Scene start,game,victory,loss;

private boolean TurnX = true;
private int [] array = new int[]{ 0,0,0,0,0,0,0,0,0}; 





private class Space extends StackPane{
	private Text shape = new Text();
	
	
	
	public Space() {
		// creates each tile 
		Rectangle border = new Rectangle(200,200);
		border.setFill(null);
		border.setStroke(Color.BLACK);
		
		//set size of shape 
		shape.setFont(Font.font(72));
		
		
		//sets alignment of tiles
		
		setAlignment(Pos.CENTER);
		getChildren().addAll(border, shape );
		
		
	//event handling
		setOnMouseClicked(event -> {
			for (int totalTurns = 0; totalTurns < array.length; totalTurns++) {	
			if(event.getButton() == MouseButton.PRIMARY) {
				//if its not x's turn dont do anything
				if(!TurnX) {
					return;
				}
				drawX();
				// sets array toX value
				array[totalTurns] = 1;
				
			// end x turn
				TurnX = false;
				
				
			}else if(event.getButton() == MouseButton.SECONDARY) {
				// if it is x's turn dont do anything
				if(TurnX) {
					return;
				}
				drawO();
				//sets array to O value
				
				
			// end O turn
				TurnX = true;
			}
			}
			
		});
	
		
		
	}
	
	//draws x
	private void drawX() {
		shape.setText("X");
		
		
	//drawsO	
	}
	private void drawO() {
		shape.setText("O");
	}
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane topRoot = new GridPane();
		topRoot.setPrefSize(200, 200);
	
		
		Text TicTac = new Text ("TicTacToe");
		TicTac.setFont(Font.font(32));
		GridPane.setConstraints(topRoot,0,2);
		TicTac.setTextAlignment(TextAlignment.CENTER);
		topRoot.setAlignment(Pos.CENTER);
		
		topRoot.add(TicTac, 0, 0);

		
		
		
		Pane root = new Pane();
		root.setPrefSize(600, 600);
		
		topRoot.add(root, 0, 1);
		

		// for loop to set the 3 by 3 grid of tiles
		//  sets the space to j and i * 200
		for(int i = 0; i< 3; i++) {
			for(int j = 0; j< 3; j ++) {
				Space tile = new Space();
				tile.setTranslateX(j*200);
				tile.setTranslateY(i*200);
				
				root.getChildren().addAll(tile);
			}
		}
		game = new Scene(topRoot,600,600);
		
		
		
		
		
		
		
		window = primaryStage;
	/////////////////////////create GridPane below/////////////////////////////////	
		GridPane startBox = new GridPane();
		GridPane.setConstraints(startBox,0,1);
		
		
	////////////////////////create greeting below///////////////////////////////	
		Text hello = new Text("welcome to tic tac toe");
		hello.setFont(Font.font(50));
	
		
		
	//////////////////////////create button below////////////////////////////////
		Button change = new Button("Click to go to scene 2");
		change.setOnAction(e -> window.setScene(game));
		
	/////////////////////////set gridPane/////////////////////////////////////////	
		startBox.add(hello, 0, 0);
		startBox.add(change, 0, 1);
	
		
		////////////////////////create scene///////////////////////////////////
		start = new Scene(startBox, 600, 600);
		
		
		/////////////////////////////////////////////////////////////
		
		
		
		
		window.setScene(start);
		window.setTitle("TicTacToe");
		window.show();
		
	}

}
