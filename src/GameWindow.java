import battleship.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameWindow extends Application {

  public static void main(String[] args) {
    launch(args);
    
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Battleship Game");

    // Initialize the game board
    Game game = new Game();
    game.initializeGameBoard();

    // Place ships of different sizes
    game.placeShipsVertical(1, 5);
    game.placeShipsVertical(1, 4);
    game.placeShipsVertical(3, 3);
    game.placeShipsVertical(3, 2);
    game.randomShot();

    // Create a GridPane to display the game board
    GridPane gridPane = new GridPane();
    for (int i = 0; i < Game.GAME_BOARD_X; i++) {
      for (int j = 0; j < Game.GAME_BOARD_Y; j++) {
        gridPane.add(game.gameBoard[i][j].getCell(), j, i);
      }
    }

    // Create a scene to display the grid
    Scene scene = new Scene(gridPane, 310, 310);

    primaryStage.setScene(scene);
    primaryStage.show();
  }

}
