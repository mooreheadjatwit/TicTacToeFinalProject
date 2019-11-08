package machineLearningTicTacToe;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TicTacToe extends Application {
	
	private int [] array = new int[]{ 0,0,0,0,0,0,0,0,0}; 

	
	private boolean TurnX = true;
	
	private boolean playable = true;
	
	private Parent Content() {
		Pane root = new Pane();
		root.setPrefSize(600, 600);

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
		
		
		return root;
		
	}

	
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
        launch(args);
    }

    
    // holds primary stage
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("TicTacToe");
		
		primaryStage.setScene(new Scene(Content()));
		primaryStage.show();
		
		
		// TODO Auto-generated method stub
		
	}
}