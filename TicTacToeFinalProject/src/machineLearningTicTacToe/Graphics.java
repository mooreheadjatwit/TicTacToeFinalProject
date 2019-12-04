package machineLearningTicTacToe;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Graphics extends Application {
	static Stage start;
	static Scene PvM, PvP;
	static int move = -1;
	static int pvp = 0;
	static int playerXWins = 0;
	static int playerOWins = 0;
	static int playerWins = 0;
	static int machineWins = 0;
	static int numTiesPvP = 0;
	static int numTiesPvM = 0;
	private static int[] moveIndex = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	public static int getMove() {
		return move;
	}

	public static int getChoice() {
		return pvp;
	}

	public static void setMoveIndex(int[] index) {
		for (int i = 0; i < 9; i++) {
			moveIndex[i] = index[i];
		}
	}

	public static void setStage(Scene scene) {
		start.setScene(scene);
	}

	public static boolean isValid(int n) {
		if (n < 9 && n >= 0) {
			if (moveIndex[n] == 0) {
				return true;
			}
		}
		return false;
	}

	public static Text xOOrBlank(int n) {
		int state = n;
		Text xText = new Text("X");
		Text oText = new Text("O");
		Text blankText = new Text(" ");

		xText.setStyle("-fx-font: 100 arial;");
		oText.setStyle("-fx-font: 100 arial;");
		blankText.setStyle("-fx-font: 32 arial;");

		if (state > 0) {
			if (state == 1) {
				return oText;
			} else {
				return xText;
			}

		}
		return blankText;

	}

	public static Scene updateBoardPvP(boolean newGame) {
		if (newGame) {
			Game.resetGameState();
		}
		setMoveIndex(Game.getGameState());
		if (Game.checkVictory(1)) {
			return winScreenPvP(1);
		}
		if (Game.checkVictory(2)) {
			return winScreenPvP(2);
		}
		if (Game.checkTie()) {
			return tieScreen(true);
		}

//		 Button PvM0 = new Button("Location 0");
//	        
//	        PvM0.setStyle("-fx-background-color: GOLDENROD");
//	        ////////
//	        //Drop shadow code pulled from Oracle Website
//	        
//	        DropShadow shadow = new DropShadow();
//	        //Adding the shadow when the mouse cursor is on
//	        PvM0.addEventHandler(MouseEvent.MOUSE_ENTERED, 
//	            new EventHandler<MouseEvent>() {
//	                @Override public void handle(MouseEvent e) {
//	                    PvM0.setEffect(shadow);
//	                }
//	        });
//	        //Removing the shadow when the mouse cursor is off
//	        PvM0.addEventHandler(MouseEvent.MOUSE_EXITED, 
//	            new EventHandler<MouseEvent>() {
//	                @Override public void handle(MouseEvent e) {
//	                    PvM0.setEffect(null);
//	                }
//	        });
//	          
//	        
//	        
//	        
//	        PvM0.setOnAction(e->{
//	            if(isValid(0)) {
//	                moveIndex[0] = Main.getTurn() ? 1 : 2;
//	                Main.setTurn();
//	                Game.setGameState(moveIndex);
//	                Game.printGameState();
//	            }
//	            start.setScene(updateBoardPvP(false));
//	        });
//	        Button PvM1 = new Button("Location 1");
//	    
//	         PvM1.setStyle("-fx-background-color: 	GOLD");
//	         ////////
//	         
//	         
//	        DropShadow shadow0 = new DropShadow();
//	         //Adding the shadow when the mouse cursor is on
//	         PvM1.addEventHandler(MouseEvent.MOUSE_ENTERED, 
//	             new EventHandler<MouseEvent>() {
//	                 @Override public void handle(MouseEvent e) {
//	                     PvM1.setEffect(shadow0);
//	                 }
//	         });
//	         //Removing the shadow when the mouse cursor is off
//	         PvM1.addEventHandler(MouseEvent.MOUSE_EXITED, 
//	             new EventHandler<MouseEvent>() {
//	                 @Override public void handle(MouseEvent e) {
//	                     PvM1.setEffect(null);
//	                 }
//	         });
//	           
//	         
//	         /////////
//	         
//	        PvM1.setOnAction(e->{
//	            if(isValid(1)) {
//	                moveIndex[1] = Main.getTurn() ? 1 : 2;
//	                Main.setTurn();
//	                Game.setGameState(moveIndex);
//	                Game.printGameState();
//	            }
//	            start.setScene(updateBoardPvP(false));
//	        });
//	        Button PvM2 = new Button("Location 2");
//	         PvM2.setStyle("-fx-background-color: GOLDENROD");
//	         ////////
//	         
//	         
//	         DropShadow shadow1 = new DropShadow();
//	         //Adding the shadow when the mouse cursor is on
//	         PvM2.addEventHandler(MouseEvent.MOUSE_ENTERED, 
//	             new EventHandler<MouseEvent>() {
//	                 @Override public void handle(MouseEvent e) {
//	                     PvM2.setEffect(shadow1);
//	                 }
//	         });
//	         //Removing the shadow when the mouse cursor is off
//	         PvM2.addEventHandler(MouseEvent.MOUSE_EXITED, 
//	             new EventHandler<MouseEvent>() {
//	                 @Override public void handle(MouseEvent e) {
//	                     PvM2.setEffect(null);
//	                 }
//	         });
//	           
//	         
//	         /////////
//	         
//	         
//	        PvM2.setOnAction(e->{
//	            if(isValid(2)) {
//	                moveIndex[2] = Main.getTurn() ? 1 : 2;
//	                Main.setTurn();
//	                Game.setGameState(moveIndex);
//	                Game.printGameState();
//	            }
//	            start.setScene(updateBoardPvP(false));
//	        });
//	        Button PvM3 = new Button("Location 3");
//	         PvM3.setStyle("-fx-background-color: 	GOLD");
//	         
//	         ////////
//	         
//	         
//	         DropShadow shadow2 = new DropShadow();
//	         //Adding the shadow when the mouse cursor is on
//	         PvM3.addEventHandler(MouseEvent.MOUSE_ENTERED, 
//	             new EventHandler<MouseEvent>() {
//	                 @Override public void handle(MouseEvent e) {
//	                     PvM3.setEffect(shadow2);
//	                 }
//	         });
//	         //Removing the shadow when the mouse cursor is off
//	         PvM3.addEventHandler(MouseEvent.MOUSE_EXITED, 
//	             new EventHandler<MouseEvent>() {
//	                 @Override public void handle(MouseEvent e) {
//	                     PvM3.setEffect(null);
//	                 }
//	         });
//	           
//	         
//	         /////////
//	         
//	        PvM3.setOnAction(e->{
//	            if(isValid(3)) {
//	                moveIndex[3] = Main.getTurn() ? 1 : 2;
//	                Main.setTurn();
//	                Game.setGameState(moveIndex);
//	                Game.printGameState();
//	            }
//	            start.setScene(updateBoardPvP(false));
//	        });
//	        Button PvM4 = new Button("Location 4");
//	         PvM4.setStyle("-fx-background-color: GOLDENROD");
//	         
//	         ////////
//	         
//	         
//	         DropShadow shadow3 = new DropShadow();
//	         //Adding the shadow when the mouse cursor is on
//	         PvM4.addEventHandler(MouseEvent.MOUSE_ENTERED, 
//	             new EventHandler<MouseEvent>() {
//	                 @Override public void handle(MouseEvent e) {
//	                     PvM4.setEffect(shadow3);
//	                 }
//	         });
//	         //Removing the shadow when the mouse cursor is off
//	         PvM4.addEventHandler(MouseEvent.MOUSE_EXITED, 
//	             new EventHandler<MouseEvent>() {
//	                 @Override public void handle(MouseEvent e) {
//	                     PvM4.setEffect(null);
//	                 }
//	         });
//	           
//	         
//	         /////////
//	         
//	        PvM4.setOnAction(e->{
//	            if(isValid(4)) {
//	                moveIndex[4] = Main.getTurn() ? 1 : 2;
//	                Main.setTurn();
//	                Game.setGameState(moveIndex);
//	                Game.printGameState();
//	            }
//	            start.setScene(updateBoardPvP(false));
//	        });
//	        Button PvM5 = new Button("Location 5");
//	        PvM5.setStyle("-fx-background-color: 	GOLD");
//	        
//	        ////////
//	        
//	        
//	        DropShadow shadow4 = new DropShadow();
//	        //Adding the shadow when the mouse cursor is on
//	        PvM5.addEventHandler(MouseEvent.MOUSE_ENTERED, 
//	            new EventHandler<MouseEvent>() {
//	                @Override public void handle(MouseEvent e) {
//	                    PvM5.setEffect(shadow4);
//	                }
//	        });
//	        //Removing the shadow when the mouse cursor is off
//	        PvM5.addEventHandler(MouseEvent.MOUSE_EXITED, 
//	            new EventHandler<MouseEvent>() {
//	                @Override public void handle(MouseEvent e) {
//	                    PvM5.setEffect(null);
//	                }
//	        });
//	          
//	        
//	        /////////
//	        
//	        
//	        PvM5.setOnAction(e->{
//	            if(isValid(5)) {
//	                moveIndex[5] = Main.getTurn() ? 1 : 2;
//	                Main.setTurn();
//	                Game.setGameState(moveIndex);
//	                Game.printGameState();
//	            }
//	            start.setScene(updateBoardPvP(false));
//	        });
//	        Button PvM6 = new Button("Location 6");
//	                PvM6.setStyle("-fx-background-color: GOLDENROD");
//	                
//	            ////////
//	                
//	                
//	                DropShadow shadow5 = new DropShadow();
//	                //Adding the shadow when the mouse cursor is on
//	                PvM6.addEventHandler(MouseEvent.MOUSE_ENTERED, 
//	                    new EventHandler<MouseEvent>() {
//	                        @Override public void handle(MouseEvent e) {
//	                            PvM6.setEffect(shadow5);
//	                        }
//	                });
//	                //Removing the shadow when the mouse cursor is off
//	                PvM6.addEventHandler(MouseEvent.MOUSE_EXITED, 
//	                    new EventHandler<MouseEvent>() {
//	                        @Override public void handle(MouseEvent e) {
//	                            PvM6.setEffect(null);
//	                        }
//	                });
//	                  
//	                
//	                /////////
//	                
//
//	        PvM6.setOnAction(e->{
//	            if(isValid(6)) {
//	                moveIndex[6] = Main.getTurn() ? 1 : 2;
//	                Main.setTurn();
//	                Game.setGameState(moveIndex);
//	                Game.printGameState();
//	            }
//	            start.setScene(updateBoardPvP(false));
//	        });
//	        Button PvM7 = new Button("Location 7");
//	                PvM7.setStyle("-fx-background-color: 	GOLD");
//	                
//	                ////////
//	                
//	                
//	                DropShadow shadow6 = new DropShadow();
//	                //Adding the shadow when the mouse cursor is on
//	                PvM7.addEventHandler(MouseEvent.MOUSE_ENTERED, 
//	                    new EventHandler<MouseEvent>() {
//	                        @Override public void handle(MouseEvent e) {
//	                            PvM7.setEffect(shadow6);
//	                        }
//	                });
//	                //Removing the shadow when the mouse cursor is off
//	                PvM7.addEventHandler(MouseEvent.MOUSE_EXITED, 
//	                    new EventHandler<MouseEvent>() {
//	                        @Override public void handle(MouseEvent e) {
//	                            PvM7.setEffect(null);
//	                        }
//	                });
//	                  
//	                
//	                /////////
//
//	        PvM7.setOnAction(e->{
//	            if(isValid(7)) {
//	                moveIndex[7] = Main.getTurn() ? 1 : 2;
//	                Main.setTurn();
//	                Game.setGameState(moveIndex);
//	                Game.printGameState();
//	            }
//	            start.setScene(updateBoardPvP(false));
//	        });
//	        Button PvM8 = new Button("Location 8");
//	        PvM8.setStyle("-fx-background-color: 	GOLDENROD");         
//	        ////////////
//	        
//	        DropShadow shadow7 = new DropShadow();
//	      //Adding the shadow when the mouse cursor is on
//	      PvM8.addEventHandler(MouseEvent.MOUSE_ENTERED, 
//	          new EventHandler<MouseEvent>() {
//	              @Override public void handle(MouseEvent e) {
//	                  PvM8.setEffect(shadow7);
//	              }
//	      });
//	      //Removing the shadow when the mouse cursor is off
//	      PvM8.addEventHandler(MouseEvent.MOUSE_EXITED, 
//	          new EventHandler<MouseEvent>() {
//	              @Override public void handle(MouseEvent e) {
//	                  PvM8.setEffect(null);
//	              }
//	      });
//	        
//	        ///////////
//	        
//	        
//	        PvM8.setOnAction(e->{
//	        	
//	            if(isValid(8)) {
//	                moveIndex[8] = Main.getTurn() ? 1 : 2;
//	                Main.setTurn();
//	                Game.setGameState(moveIndex);
//	                Game.printGameState();
//	            }
//	            start.setScene(updateBoardPvP(false));
//	        });
//		
//		
//		

		Text pvmText = new Text("Player vs Player");
//		HBox pvm1 = new HBox(10);
//		pvm1.getChildren().addAll(PvM0, PvM1, PvM2);
//		HBox pvm2 = new HBox(10);
//		pvm2.getChildren().addAll(PvM3, PvM4, PvM5);
//		HBox pvm3 = new HBox(10);
//		pvm3.getChildren().addAll(PvM6, PvM7, PvM8);
//		VBox pvmBoard = new VBox(10);
//		pvmBoard.getChildren().addAll(pvm1, pvm2, pvm3);
		VBox pvmDisplay = new VBox(20);
		pvmDisplay.getChildren().add(pvmText);

		GridPane board = new GridPane();
		GridPane.setConstraints(board, 2, 2);

		Rectangle border0 = new Rectangle(200, 200);
		border0.setFill(Color.WHITE);
		border0.setStroke(Color.BLACK);
		Text text0 = xOOrBlank(moveIndex[0]);
		StackPane bord0 = new StackPane();
		bord0.getChildren().addAll(border0, text0);
		//////////////////////// Event Handler below///////////////////////

		border0.setOnMouseClicked(event -> {

			if (event.getButton() == MouseButton.PRIMARY) {

				if (isValid(0)) {
					moveIndex[0] = Main.getTurn() ? 1 : 2;
					Main.setTurn();
					Game.setGameState(moveIndex);
					Game.printGameState();
				}
				start.setScene(updateBoardPvP(false));

			}

		});

///////////////////Event Handler above//////////////////

		Rectangle border1 = new Rectangle(200, 200);
		border1.setFill(Color.WHITE);
		border1.setStroke(Color.BLACK);
		Text text1 = xOOrBlank(moveIndex[1]);
		StackPane bord1 = new StackPane();
		bord1.getChildren().addAll(border1, text1);

		//////////////////////// Event Handler below///////////////////////

		border1.setOnMouseClicked(event -> {

			if (event.getButton() == MouseButton.PRIMARY) {

				if (isValid(1)) {
					moveIndex[1] = Main.getTurn() ? 1 : 2;
					Main.setTurn();
					Game.setGameState(moveIndex);
					Game.printGameState();
				}
				start.setScene(updateBoardPvP(false));

			}

		});

///////////////////Event Handler above//////////////////

		Rectangle border2 = new Rectangle(200, 200);
		border2.setFill(Color.WHITE);
		border2.setStroke(Color.BLACK);
		Text text2 = xOOrBlank(moveIndex[2]);
		StackPane bord2 = new StackPane();
		bord2.getChildren().addAll(border2, text2);

		//////////////////////// Event Handler below///////////////////////

		border2.setOnMouseClicked(event -> {

			if (event.getButton() == MouseButton.PRIMARY) {

				if (isValid(2)) {
					moveIndex[2] = Main.getTurn() ? 1 : 2;
					Main.setTurn();
					Game.setGameState(moveIndex);
					Game.printGameState();
				}
				start.setScene(updateBoardPvP(false));

			}

		});

///////////////////Event Handler above//////////////////

		Rectangle border3 = new Rectangle(200, 200);
		border3.setFill(Color.WHITE);
		border3.setStroke(Color.BLACK);
		Text text3 = xOOrBlank(moveIndex[3]);
		StackPane bord3 = new StackPane();
		bord3.getChildren().addAll(border3, text3);

		//////////////////////// Event Handler below///////////////////////

		border3.setOnMouseClicked(event -> {

			if (event.getButton() == MouseButton.PRIMARY) {

				if (isValid(3)) {
					moveIndex[3] = Main.getTurn() ? 1 : 2;
					Main.setTurn();
					Game.setGameState(moveIndex);
					Game.printGameState();
				}
				start.setScene(updateBoardPvP(false));

			}

		});

///////////////////Event Handler above//////////////////

		Rectangle border4 = new Rectangle(200, 200);
		border4.setFill(Color.WHITE);
		border4.setStroke(Color.BLACK);
		Text text4 = xOOrBlank(moveIndex[4]);
		StackPane bord4 = new StackPane();
		bord4.getChildren().addAll(border4, text4);

		//////////////////////// Event Handler below///////////////////////

		border4.setOnMouseClicked(event -> {

			if (event.getButton() == MouseButton.PRIMARY) {

				if (isValid(4)) {
					moveIndex[4] = Main.getTurn() ? 1 : 2;
					Main.setTurn();
					Game.setGameState(moveIndex);
					Game.printGameState();
				}
				start.setScene(updateBoardPvP(false));

			}

		});

///////////////////Event Handler above//////////////////

		Rectangle border5 = new Rectangle(200, 200);
		border5.setFill(Color.WHITE);
		border5.setStroke(Color.BLACK);
		Text text5 = xOOrBlank(moveIndex[5]);
		StackPane bord5 = new StackPane();
		bord5.getChildren().addAll(border5, text5);

		//////////////////////// Event Handler below///////////////////////

		border5.setOnMouseClicked(event -> {

			if (event.getButton() == MouseButton.PRIMARY) {

				if (isValid(5)) {
					moveIndex[5] = Main.getTurn() ? 1 : 2;
					Main.setTurn();
					Game.setGameState(moveIndex);
					Game.printGameState();
				}
				start.setScene(updateBoardPvP(false));

			}

		});

///////////////////Event Handler above//////////////////

		Rectangle border6 = new Rectangle(200, 200);
		border6.setFill(Color.WHITE);
		border6.setStroke(Color.BLACK);
		Text text6 = xOOrBlank(moveIndex[6]);
		StackPane bord6 = new StackPane();
		bord6.getChildren().addAll(border6, text6);

		//////////////////////// Event Handler below///////////////////////

		border6.setOnMouseClicked(event -> {

			if (event.getButton() == MouseButton.PRIMARY) {

				if (isValid(6)) {
					moveIndex[6] = Main.getTurn() ? 1 : 2;
					Main.setTurn();
					Game.setGameState(moveIndex);
					Game.printGameState();
				}
				start.setScene(updateBoardPvP(false));

			}

		});

///////////////////Event Handler above//////////////////

		Rectangle border7 = new Rectangle(200, 200);
		border7.setFill(Color.WHITE);
		border7.setStroke(Color.BLACK);
		Text text7 = xOOrBlank(moveIndex[7]);
		StackPane bord7 = new StackPane();
		bord7.getChildren().addAll(border7, text7);

		//////////////////////// Event Handler below///////////////////////

		border7.setOnMouseClicked(event -> {

			if (event.getButton() == MouseButton.PRIMARY) {

				if (isValid(7)) {
					moveIndex[7] = Main.getTurn() ? 1 : 2;
					Main.setTurn();
					Game.setGameState(moveIndex);
					Game.printGameState();
				}
				start.setScene(updateBoardPvP(false));

			}

		});

///////////////////Event Handler above//////////////////

		Rectangle border8 = new Rectangle(200, 200);
		border8.setFill(Color.WHITE);
		border8.setStroke(Color.BLACK);
		Text text8 = xOOrBlank(moveIndex[8]);
		StackPane bord8 = new StackPane();
		bord8.getChildren().addAll(border8, text8);

		//////////////////////// Event Handler below///////////////////////

		border8.setOnMouseClicked(event -> {

			if (event.getButton() == MouseButton.PRIMARY) {

				if (isValid(8)) {
					moveIndex[8] = Main.getTurn() ? 1 : 2;
					Main.setTurn();
					Game.setGameState(moveIndex);
					Game.printGameState();
				}
				start.setScene(updateBoardPvP(false));

			}

		});

///////////////////Event Handler above//////////////////

		board.add(bord0, 0, 0);
		board.add(bord1, 1, 0);
		board.add(bord2, 2, 0);
		board.add(bord3, 0, 1);
		board.add(bord4, 1, 1);
		board.add(bord5, 2, 1);
		board.add(bord6, 0, 2);
		board.add(bord7, 1, 2);
		board.add(bord8, 2, 2);
		HBox pvmDisplay1 = new HBox(30);
		pvmDisplay1.getChildren().addAll(pvmDisplay, board);
		PvM = new Scene(pvmDisplay1, 1000, 800);
		return PvM;
	}

	///////////////////////////////////////////////////////////////////////
	public static Scene updateBoardPvM(boolean newGame, MachineMove yaBoi) {
		if (newGame) {
			Game.resetGameState();
		}
		setMoveIndex(Game.getGameState());
		if (Game.checkVictory(1)) {
			return loseScreen(yaBoi);
		}
		if (Game.checkVictory(2)) {
			return winScreenPvM(yaBoi);
		}
		if (Game.checkTie()) {
			return tieScreen(false);
		}

//		Button PvM0 = new Button("Location 0");
//		PvM0.setStyle("-fx-background-color: GOLDENROD");
//
//		////////
//
//		DropShadow shadow = new DropShadow();
//		// Adding the shadow when the mouse cursor is on
//		PvM0.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				PvM0.setEffect(shadow);
//			}
//		});
//		// Removing the shadow when the mouse cursor is off
//		PvM0.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				PvM0.setEffect(null);
//			}
//		});
//
//		/////////
//
//		PvM0.setOnAction(e -> {
//
//			if (isValid(0)) {
//				moveIndex[0] = 2;
//				Main.setTurn();
//				Game.setGameState(moveIndex);
//				if (Game.checkVictory(2) || Game.checkTie()) {
//					start.setScene(updateBoardPvM(false, yaBoi));
//				} else {
//					yaBoi.play();
//				}
//
//			}
//			start.setScene(updateBoardPvM(false, yaBoi));
//		});
//		Button PvM1 = new Button("Location 1");
//		PvM1.setStyle("-fx-background-color: 	GOLD");
//
//		////////
//
//		DropShadow shadow1 = new DropShadow();
//		// Adding the shadow when the mouse cursor is on
//		PvM1.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				PvM1.setEffect(shadow1);
//			}
//		});
//		// Removing the shadow when the mouse cursor is off
//		PvM1.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				PvM1.setEffect(null);
//			}
//		});
//
//		/////////
//
//		PvM1.setOnAction(e -> {
//			if (isValid(1)) {
//				moveIndex[1] = 2;
//				Main.setTurn();
//				Game.setGameState(moveIndex);
//				if (Game.checkVictory(2) || Game.checkTie()) {
//					start.setScene(updateBoardPvM(false, yaBoi));
//				} else {
//					yaBoi.play();
//				}
//
//			}
//			start.setScene(updateBoardPvM(false, yaBoi));
//		});
//		Button PvM2 = new Button("Location 2");
//		PvM2.setStyle("-fx-background-color: GOLDENROD");
//
//		////////
//
//		DropShadow shadow3 = new DropShadow();
//		// Adding the shadow when the mouse cursor is on
//		PvM2.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				PvM2.setEffect(shadow3);
//			}
//		});
//		// Removing the shadow when the mouse cursor is off
//		PvM2.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				PvM2.setEffect(null);
//			}
//		});
//
//		/////////
//
//		PvM2.setOnAction(e -> {
//			if (isValid(2)) {
//				moveIndex[2] = 2;
//				Main.setTurn();
//				Game.setGameState(moveIndex);
//				if (Game.checkVictory(2) || Game.checkTie()) {
//					start.setScene(updateBoardPvM(false, yaBoi));
//				} else {
//					yaBoi.play();
//				}
//
//			}
//			start.setScene(updateBoardPvM(false, yaBoi));
//		});
//		Button PvM3 = new Button("Location 3");
//		PvM3.setStyle("-fx-background-color: 	GOLD");
//
//		////////
//
//		DropShadow shadow4 = new DropShadow();
//		// Adding the shadow when the mouse cursor is on
//		PvM3.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				PvM3.setEffect(shadow4);
//			}
//		});
//		// Removing the shadow when the mouse cursor is off
//		PvM3.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				PvM3.setEffect(null);
//			}
//		});
//
//		/////////
//
//		PvM3.setOnAction(e -> {
//			if (isValid(3)) {
//				moveIndex[3] = 2;
//				Main.setTurn();
//				Game.setGameState(moveIndex);
//				if (Game.checkVictory(2) || Game.checkTie()) {
//					start.setScene(updateBoardPvM(false, yaBoi));
//				} else {
//					yaBoi.play();
//				}
//
//			}
//			start.setScene(updateBoardPvM(false, yaBoi));
//		});
//		Button PvM4 = new Button("Location 4");
//		PvM4.setStyle("-fx-background-color: GOLDENROD");
//
//		////////
//
//		DropShadow shadow5 = new DropShadow();
//		// Adding the shadow when the mouse cursor is on
//		PvM4.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				PvM4.setEffect(shadow5);
//			}
//		});
//		// Removing the shadow when the mouse cursor is off
//		PvM4.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				PvM4.setEffect(null);
//			}
//		});
//
//		/////////
//
//		PvM4.setOnAction(e -> {
//			if (isValid(4)) {
//				moveIndex[4] = 2;
//				Main.setTurn();
//				Game.setGameState(moveIndex);
//				if (Game.checkVictory(2) || Game.checkTie()) {
//					start.setScene(updateBoardPvM(false, yaBoi));
//				} else {
//					yaBoi.play();
//				}
//
//			}
//			start.setScene(updateBoardPvM(false, yaBoi));
//		});
//		Button PvM5 = new Button("Location 5");
//		PvM5.setStyle("-fx-background-color: 	GOLD");
//
//		////////
//
//		DropShadow shadow6 = new DropShadow();
//		// Adding the shadow when the mouse cursor is on
//		PvM5.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				PvM5.setEffect(shadow6);
//			}
//		});
//		// Removing the shadow when the mouse cursor is off
//		PvM5.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				PvM5.setEffect(null);
//			}
//		});
//
//		/////////
//
//		PvM5.setOnAction(e -> {
//			if (isValid(5)) {
//				moveIndex[5] = 2;
//				Main.setTurn();
//				Game.setGameState(moveIndex);
//				if (Game.checkVictory(2) || Game.checkTie()) {
//					start.setScene(updateBoardPvM(false, yaBoi));
//				} else {
//					yaBoi.play();
//				}
//
//			}
//			start.setScene(updateBoardPvM(false, yaBoi));
//		});
//		Button PvM6 = new Button("Location 6");
//		PvM6.setStyle("-fx-background-color: GOLDENROD");
//
//		////////
//
//		DropShadow shadow7 = new DropShadow();
//		// Adding the shadow when the mouse cursor is on
//		PvM6.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				PvM6.setEffect(shadow7);
//			}
//		});
//		// Removing the shadow when the mouse cursor is off
//		PvM6.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				PvM6.setEffect(null);
//			}
//		});
//
//		/////////
//
//		PvM6.setOnAction(e -> {
//			if (isValid(6)) {
//				moveIndex[6] = 2;
//				Main.setTurn();
//				Game.setGameState(moveIndex);
//				if (Game.checkVictory(2) || Game.checkTie()) {
//					start.setScene(updateBoardPvM(false, yaBoi));
//				} else {
//					yaBoi.play();
//				}
//
//			}
//			start.setScene(updateBoardPvM(false, yaBoi));
//		});
//		Button PvM7 = new Button("Location 7");
//
//		PvM7.setStyle("-fx-background-color: 	GOLD");
//		////////
//
//		DropShadow shadow8 = new DropShadow();
//		// Adding the shadow when the mouse cursor is on
//		PvM7.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				PvM7.setEffect(shadow8);
//			}
//		});
//		// Removing the shadow when the mouse cursor is off
//		PvM7.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				PvM7.setEffect(null);
//			}
//		});
//
//		/////////
//
//		PvM7.setOnAction(e -> {
//			if (isValid(7)) {
//				moveIndex[7] = 2;
//				Main.setTurn();
//				Game.setGameState(moveIndex);
//				if (Game.checkVictory(2) || Game.checkTie()) {
//					start.setScene(updateBoardPvM(false, yaBoi));
//				} else {
//					yaBoi.play();
//				}
//
//			}
//			start.setScene(updateBoardPvM(false, yaBoi));
//		});
//		Button PvM8 = new Button("Location 8");
//
//		PvM8.setStyle("-fx-background-color: GOLDENROD");
//		////////
//
//		DropShadow shadow9 = new DropShadow();
//		// Adding the shadow when the mouse cursor is on
//		PvM8.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				PvM8.setEffect(shadow9);
//			}
//		});
//		// Removing the shadow when the mouse cursor is off
//		PvM8.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				PvM8.setEffect(null);
//			}
//		});
//
//		/////////
//
//		PvM8.setOnAction(e -> {
//			if (isValid(8)) {
//				moveIndex[8] = 2;
//				Main.setTurn();
//				Game.setGameState(moveIndex);
//				if (Game.checkVictory(2) || Game.checkTie()) {
//					start.setScene(updateBoardPvM(false, yaBoi));
//				} else {
//					yaBoi.play();
//				}
//			}
//			start.setScene(updateBoardPvM(false, yaBoi));
//		});
		Text pvmText = new Text("Player vs Machine");
//		HBox pvm1 = new HBox(10);
//		pvm1.getChildren().addAll(PvM0, PvM1, PvM2);
//		HBox pvm2 = new HBox(10);
//		pvm2.getChildren().addAll(PvM3, PvM4, PvM5);
//		HBox pvm3 = new HBox(10);
//		pvm3.getChildren().addAll(PvM6, PvM7, PvM8);
//		VBox pvmBoard = new VBox(10);
//		pvmBoard.getChildren().addAll(pvm1, pvm2, pvm3);
		VBox pvmDisplay = new VBox(20);
		pvmDisplay.getChildren().add(pvmText);

		GridPane board = new GridPane();
		GridPane.setConstraints(board, 2, 2);

		Rectangle border0 = new Rectangle(200, 200);
		border0.setFill(Color.WHITE);
		border0.setStroke(Color.BLACK);
		Text text0 = xOOrBlank(moveIndex[0]);
		StackPane bord0 = new StackPane();
		bord0.getChildren().addAll(border0, text0);

////////////////////Event Handler Above////////////////////////////////
		border0.setOnMouseClicked(event -> {

			if (event.getButton() == MouseButton.PRIMARY) {

				moveIndex[0] = 2;
				Main.setTurn();
				Game.setGameState(moveIndex);
				if (Game.checkVictory(2) || Game.checkTie()) {
					start.setScene(updateBoardPvM(false, yaBoi));
				} else {
					yaBoi.play();
				}
				start.setScene(updateBoardPvM(false, yaBoi));
			}

		});

/////////////////////////////////////Event Handler above//////////////////////

		Rectangle border1 = new Rectangle(200, 200);
		border1.setFill(Color.WHITE);
		border1.setStroke(Color.BLACK);
		Text text1 = xOOrBlank(moveIndex[1]);
		StackPane bord1 = new StackPane();
		bord1.getChildren().addAll(border1, text1);

////////////////////Event Handler Above////////////////////////////////
		border1.setOnMouseClicked(event -> {

			if (event.getButton() == MouseButton.PRIMARY) {

				moveIndex[1] = 2;
				Main.setTurn();
				Game.setGameState(moveIndex);
				if (Game.checkVictory(2) || Game.checkTie()) {
					start.setScene(updateBoardPvM(false, yaBoi));
				} else {
					yaBoi.play();
				}
				start.setScene(updateBoardPvM(false, yaBoi));
			}

		});

/////////////////////////////////////Event Handler above//////////////////////

		Rectangle border2 = new Rectangle(200, 200);
		border2.setFill(Color.WHITE);
		border2.setStroke(Color.BLACK);
		Text text2 = xOOrBlank(moveIndex[2]);
		StackPane bord2 = new StackPane();
		bord2.getChildren().addAll(border2, text2);

////////////////////Event Handler Above////////////////////////////////
		border2.setOnMouseClicked(event -> {

			if (event.getButton() == MouseButton.PRIMARY) {

				moveIndex[2] = 2;
				Main.setTurn();
				Game.setGameState(moveIndex);
				if (Game.checkVictory(2) || Game.checkTie()) {
					start.setScene(updateBoardPvM(false, yaBoi));
				} else {
					yaBoi.play();
				}
				start.setScene(updateBoardPvM(false, yaBoi));
			}

		});

/////////////////////////////////////Event Handler above//////////////////////

		Rectangle border3 = new Rectangle(200, 200);
		border3.setFill(Color.WHITE);
		border3.setStroke(Color.BLACK);
		Text text3 = xOOrBlank(moveIndex[3]);
		StackPane bord3 = new StackPane();
		bord3.getChildren().addAll(border3, text3);

////////////////////Event Handler Above////////////////////////////////
		border3.setOnMouseClicked(event -> {

			if (event.getButton() == MouseButton.PRIMARY) {

				moveIndex[3] = 2;
				Main.setTurn();
				Game.setGameState(moveIndex);
				if (Game.checkVictory(2) || Game.checkTie()) {
					start.setScene(updateBoardPvM(false, yaBoi));
				} else {
					yaBoi.play();
				}
				start.setScene(updateBoardPvM(false, yaBoi));
			}

		});

/////////////////////////////////////Event Handler above//////////////////////

		Rectangle border4 = new Rectangle(200, 200);
		border4.setFill(Color.WHITE);
		border4.setStroke(Color.BLACK);
		Text text4 = xOOrBlank(moveIndex[4]);
		StackPane bord4 = new StackPane();
		bord4.getChildren().addAll(border4, text4);

////////////////////Event Handler Above////////////////////////////////
		border4.setOnMouseClicked(event -> {

			if (event.getButton() == MouseButton.PRIMARY) {

				moveIndex[4] = 2;
				Main.setTurn();
				Game.setGameState(moveIndex);
				if (Game.checkVictory(2) || Game.checkTie()) {
					start.setScene(updateBoardPvM(false, yaBoi));
				} else {
					yaBoi.play();
				}
				start.setScene(updateBoardPvM(false, yaBoi));
			}

		});

/////////////////////////////////////Event Handler above//////////////////////

		Rectangle border5 = new Rectangle(200, 200);
		border5.setFill(Color.WHITE);
		border5.setStroke(Color.BLACK);
		Text text5 = xOOrBlank(moveIndex[5]);
		StackPane bord5 = new StackPane();
		bord5.getChildren().addAll(border5, text5);

////////////////////Event Handler Above////////////////////////////////
		border5.setOnMouseClicked(event -> {

			if (event.getButton() == MouseButton.PRIMARY) {

				moveIndex[5] = 2;
				Main.setTurn();
				Game.setGameState(moveIndex);
				if (Game.checkVictory(2) || Game.checkTie()) {
					start.setScene(updateBoardPvM(false, yaBoi));
				} else {
					yaBoi.play();
				}
				start.setScene(updateBoardPvM(false, yaBoi));
			}

		});

/////////////////////////////////////Event Handler above//////////////////////

		Rectangle border6 = new Rectangle(200, 200);
		border6.setFill(Color.WHITE);
		border6.setStroke(Color.BLACK);
		Text text6 = xOOrBlank(moveIndex[6]);
		StackPane bord6 = new StackPane();
		bord6.getChildren().addAll(border6, text6);

////////////////////Event Handler Above////////////////////////////////
		border6.setOnMouseClicked(event -> {

			if (event.getButton() == MouseButton.PRIMARY) {

				moveIndex[6] = 2;
				Main.setTurn();
				Game.setGameState(moveIndex);
				if (Game.checkVictory(2) || Game.checkTie()) {
					start.setScene(updateBoardPvM(false, yaBoi));
				} else {
					yaBoi.play();
				}
				start.setScene(updateBoardPvM(false, yaBoi));
			}

		});

/////////////////////////////////////Event Handler above//////////////////////

		Rectangle border7 = new Rectangle(200, 200);
		border7.setFill(Color.WHITE);
		border7.setStroke(Color.BLACK);
		Text text7 = xOOrBlank(moveIndex[7]);
		StackPane bord7 = new StackPane();
		bord7.getChildren().addAll(border7, text7);

////////////////////Event Handler Above////////////////////////////////
		border7.setOnMouseClicked(event -> {

			if (event.getButton() == MouseButton.PRIMARY) {

				moveIndex[7] = 2;
				Main.setTurn();
				Game.setGameState(moveIndex);
				if (Game.checkVictory(2) || Game.checkTie()) {
					start.setScene(updateBoardPvM(false, yaBoi));
				} else {
					yaBoi.play();
				}
				start.setScene(updateBoardPvM(false, yaBoi));
			}

		});

/////////////////////////////////////Event Handler above//////////////////////

		Rectangle border8 = new Rectangle(200, 200);
		border8.setFill(Color.WHITE);
		border8.setStroke(Color.BLACK);
		Text text8 = xOOrBlank(moveIndex[8]);
		StackPane bord8 = new StackPane();
		bord8.getChildren().addAll(border8, text8);

////////////////////Event Handler Above////////////////////////////////
		border8.setOnMouseClicked(event -> {

			if (event.getButton() == MouseButton.PRIMARY) {

				moveIndex[8] = 2;
				Main.setTurn();
				Game.setGameState(moveIndex);
				if (Game.checkVictory(2) || Game.checkTie()) {
					start.setScene(updateBoardPvM(false, yaBoi));
				} else {
					yaBoi.play();
				}
				start.setScene(updateBoardPvM(false, yaBoi));
			}

		});

/////////////////////////////////////Event Handler above//////////////////////

		board.add(bord0, 0, 0);
		board.add(bord1, 1, 0);
		board.add(bord2, 2, 0);
		board.add(bord3, 0, 1);
		board.add(bord4, 1, 1);
		board.add(bord5, 2, 1);
		board.add(bord6, 0, 2);
		board.add(bord7, 1, 2);
		board.add(bord8, 2, 2);
		HBox pvmDisplay1 = new HBox(30);
		pvmDisplay1.getChildren().addAll(pvmDisplay, board);
		PvM = new Scene(pvmDisplay1, 1000, 800);
		return PvM;
	}

	public static Scene tieScreen(boolean PvP) {
		Text wins;
		Text loses;
		Text ties;
		if (PvP) {
			wins = new Text("Player X: " + String.valueOf(playerXWins));
			loses = new Text("Player O: " + String.valueOf(playerOWins));
			numTiesPvP++;
			ties = new Text("Total Ties: " + String.valueOf(numTiesPvP));
		} else {
			wins = new Text("Machine: " + String.valueOf(machineWins));
			loses = new Text("Player: " + String.valueOf(playerWins / 2));
			numTiesPvM++;
			ties = new Text("Total Ties: " + String.valueOf(numTiesPvM / 2));
		}
		Text tieText = new Text("You have Tied");
		Text scoreText = new Text("Current Score");

		Text playAgain = new Text("Would you like to play again or change GameMode?");
		Button yesAgain = new Button("Yes");
		yesAgain.setOnAction(e -> {
			if (PvP) {
				start.setScene(updateBoardPvP(true));
			} else {
				MachineMove yaBoi = new MachineMove(1);
				start.setScene(updateBoardPvM(true, yaBoi));
			}
		});
		Button noAgain = new Button("No");
		noAgain.setOnAction(e -> {
			start.close();
			System.exit(1);
		});
		Button choiceHome = new Button("Change GameMode");
		choiceHome.setOnAction(e -> homeScreen());
		HBox choiceHBox = new HBox(20);
		choiceHBox.getChildren().addAll(yesAgain, noAgain);
		VBox loseVBox = new VBox(10);
		loseVBox.getChildren().addAll(tieText, scoreText, wins, loses, ties, playAgain, choiceHBox, choiceHome);
		Scene loseScreen = new Scene(loseVBox, 800, 800);
		return loseScreen;
	}

	public static Scene winScreenPvM(MachineMove yaBoi) {
		playerWins++;
		yaBoi.learn(2);
		Text winText = new Text("Congradulations Player, You have Won");
		Text scoreText = new Text("Current Score");
		Text playerXWin = new Text("Machine: " + String.valueOf(machineWins));
		Text playerOWin = new Text("Player: " + String.valueOf(playerWins / 2));
		Text ties = new Text("Total Ties: " + String.valueOf(numTiesPvM / 2));
		Text playAgain = new Text("Would you like to play again or change GameMode?");
		Button yesAgain = new Button("Yes");
		yesAgain.setOnAction(e -> {
			MachineMove yaBoi2 = new MachineMove(1);
			start.setScene(updateBoardPvM(true, yaBoi2));
		});
		Button noAgain = new Button("No");
		noAgain.setOnAction(e -> start.close());
		Button choiceHome = new Button("Change GameMode");
		choiceHome.setOnAction(e -> homeScreen());
		HBox choiceHBox = new HBox(20);
		choiceHBox.getChildren().addAll(yesAgain, noAgain);
		VBox winVBox = new VBox(10);
		winVBox.getChildren().addAll(winText, scoreText, playerXWin, playerOWin, ties, playAgain, choiceHBox,
				choiceHome);
		Scene winScreen = new Scene(winVBox, 800, 800);
		return winScreen;
	}

	public static Scene winScreenPvP(int moveNumber) {
		Text winText;
		if (moveNumber == 1) {
			winText = new Text("Congradulations Player O, You have Won");
			playerOWins++;
		} else {
			winText = new Text("Congradulations Player X, You have Won");
			playerXWins++;
		}
		Text scoreText = new Text("Current Score");
		Text playerXWin = new Text("Player X: " + String.valueOf(playerXWins));
		Text playerOWin = new Text("Player O: " + String.valueOf(playerOWins));
		Text ties = new Text("Total Ties: " + String.valueOf(numTiesPvP));
		Text playAgain = new Text("Would you like to play again or change GameMode?");
		Button yesAgain = new Button("Yes");
		yesAgain.setOnAction(e -> {
			// PvM = updateBoardPvP(true);
			start.setScene(updateBoardPvP(true));
		});
		Button noAgain = new Button("No");
		noAgain.setOnAction(e -> start.close());
		Button choiceHome = new Button("Change GameMode");
		choiceHome.setOnAction(e -> homeScreen());
		HBox choiceHBox = new HBox(20);
		choiceHBox.getChildren().addAll(yesAgain, noAgain);
		VBox winVBox = new VBox(10);
		winVBox.getChildren().addAll(winText, scoreText, playerXWin, playerOWin, ties, playAgain, choiceHBox,
				choiceHome);
		Scene winScreen = new Scene(winVBox, 800, 800);
		return winScreen;
	}

	public static Scene loseScreen(MachineMove yaBoi) {
		machineWins++;
		yaBoi.learn(1);
		Text loseText = new Text("Unfortunately You have Lost");
		Text scoreText = new Text("Current Score");
		Text playerWin = new Text("Player: " + String.valueOf(playerWins / 2));
		Text machineWin = new Text("Machine: " + String.valueOf(machineWins));
		Text ties = new Text("Total Ties: " + String.valueOf(numTiesPvM / 2));
		Text playAgain = new Text("Would you like to play again or change GameMode?");
		Button yesAgain = new Button("Yes");
		yesAgain.setOnAction(e -> {
			MachineMove yaBoi2 = new MachineMove(1);
			start.setScene(updateBoardPvM(true, yaBoi2));
		});
		Button noAgain = new Button("No");
		noAgain.setOnAction(e -> start.close());
		Button choiceHome = new Button("Change GameMode");
		choiceHome.setOnAction(e -> homeScreen());
		HBox choiceHBox = new HBox(20);
		choiceHBox.getChildren().addAll(yesAgain, noAgain);
		VBox loseVBox = new VBox(10);
		loseVBox.getChildren().addAll(loseText, scoreText, playerWin, machineWin, ties, playAgain, choiceHBox,
				choiceHome);
		Scene loseScreen = new Scene(loseVBox, 800, 800);
		return loseScreen;
	}

	public static void homeScreen() {
		Text startText1 = new Text("Welcome to Tic Tac Toe");
		Text startText2 = new Text("Please Chose Player vs Player or Player vs Machine");
		Button playerVsPlayer = new Button("Player vs Player");
		playerVsPlayer.setOnAction(e -> {
			start.setScene(updateBoardPvP(true));
			Game.resetGameState();
		});
		Button playerVsMachine = new Button("Player vs Machine");
		playerVsMachine.setOnAction(e -> {
			MachineMove yaBoi = new MachineMove(1);
			start.setScene(updateBoardPvM(true, yaBoi));
			Game.resetGameState();
		});
		HBox startHBox = new HBox(20);
		startHBox.getChildren().addAll(playerVsPlayer, playerVsMachine);
		VBox startVBox = new VBox(10);
		startVBox.getChildren().addAll(startText1, startText2, startHBox);
		Scene origin = new Scene(startVBox, 400, 400);
		start.setScene(origin);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		start = primaryStage;
		homeScreen();
		start.setTitle("TicTacToe");
		start.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
