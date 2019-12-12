# Machine Learning Tic Tac Toe

## Description

This project is a Tic-Tac-Toe game capable of machine learning AI and pvp play. It will use object oriented Java design and class inheritance to break the program into functional and collaboratable pieces. 

The graphics and user input are done with JavaFX and have much of the game logic built into the scenes that it transfers between.

The Machine learning part of it is very simple and based off M.E.N.A.C.E (Machine Educable Noughts And Crosses Engine) https://www.mscroggs.co.uk/blog/19   The simple nature of tictactoe and the learning model allow it to be coded only using ArrayLists and simple arrays along with data IO for writing to the persistent brain storage. 
## Getting Started
### Install
1. Clone this repository to Eclipse.
2. Add the JavaFX External Jar to the build path for the project.
### Run
#### Run "Graphics.java" for the full experience.
  1. Select what mode you want. 'PvP' is a two player game. 'PvM' is a one player game using the machine learning bot.
  2. Left click on a tile to select it. In PvP turns will alternate. In PvM the Machine will go immediately after you.
      At this time there is a bug that if you click close to the exact center of a tile it will not work. 
  3. At the end of a game you can select to play again, exit, or switch gamemodes. 
  4. If in PvM, the machine will write its new teachings to bigBrain.txt after each game.
#### Run "LonelyLearning.java" to have the machine learn against itself. 
  1. The variable numGames indicates how many games to run. On a good laptop I can do a little over 10 games per second.
  2. The boolean random indicates whether it is playing against a random bot or a copy of itself.
        When training I had it train 50/50.
  3. When LonelyLearning, the gameState will be printed every move to console. 
  4. The machine will learn after each game it wins or loses.

## Features 
List all the features of your application in the order of priority.
1. Play Tic-Tac-Toe 
2. Good Graphical Interface 
3. Machine Learning AI 
4. Able to choose PVP or PVM 
5. Repeating gameplay 
6. Score keeper 
7. Victory or Loss Screens 
## Demo video 

https://www.youtube.com/watch?v=2oOXGgB43XY

## References

Release: JavaFX 2.2. Using JavaFX UI Controls: Button | JavaFX 2 Tutorials and Documentation, 27 Aug. 2013, docs.oracle.com/javafx/2/ui_controls/button.htm.

TomJTomJ 1, et al. How to Change the Text Font Size in Javafx? Stack Overflow, 1 Apr. 1964, stackoverflow.com/questions/22047457/how-to-change-the-text-font-size-in-javafx.

Rahman, Waliur RahmanWaliur. Button Color Change in Javafx. Stack Overflow, 1 Apr. 1968, stackoverflow.com/questions/49149502/button-color-change-in-javafx.

Meyer, Sam De MeyerSam De. Handle Mouse Event Anywhere with JavaFX. Stack Overflow, 1 Oct. 1963, stackoverflow.com/questions/18597939/handle-mouse-event-anywhere-with-javafx.
 
Modification of a method from StackOverflow User Andrey Adamovich : https://stackoverflow.com/questions/6548157/how-to-write-an-arraylist-of-strings-into-a-text-file

Modification of a method found from StackOverFlow user YoYo : https://stackoverflow.com/questions/18838781/converting-string-array-to-an-integer-array
## Team members

* Max Moynihan, Machine Learning Lead
* Matthew Benedict, Graphics Department
* Joshua Moorehead, Chief Integration Officer
