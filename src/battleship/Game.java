package battleship;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Game {
  public static int GAME_BOARD_X = 10;
  public static int GAME_BOARD_Y = 10;
  private static int NUMBER_OF_SHIPS = 3;
  public static CellInfo[][] gameBoard = new CellInfo[GAME_BOARD_X][GAME_BOARD_Y];

  public static class CellInfo {
    private Rectangle cell = new Rectangle(30, 30, Color.BLUE); // Initialize with a white rectangle

    public CellInfo() {
      cell.setStroke(Color.BLACK); // Color borders of cell
    }

    public Rectangle getCell() {
      return cell;
    }
  }

  public void initializeGameBoard() {
    for (int i = 0; i < GAME_BOARD_X; i++) {
      for (int j = 0; j < GAME_BOARD_Y; j++) {
        gameBoard[i][j] = new CellInfo();
      }
    }
  }

  public void placeShips(int numShips) {
    System.out.println("Deploying " + numShips + " random ships");

    Random random = new Random();

    // For loop to deploy ships based on numShips. 5 = 5 ships, 3 = 3 etc.
    for (int shipCount = 0; shipCount < numShips; shipCount++) {
      int x = random.nextInt(GAME_BOARD_X);
//      int x = 0;
      int y = random.nextInt(GAME_BOARD_Y);
//      int y = 0;

      // Check if the cell is water (blue)
      if (isCellBlue(x, y)) {
//        if (hasBlueNeighbor(x, y)) { // check if cell is surrounded by blue cells
//          // If the cell is blue, change color to GRAY (ship color)
//          gameBoard[x][y].getCell().setFill(Color.GRAY);
//          System.out.println("#" + (shipCount + 1) + " Ship coordinates: (" + x + ", " + y + ")");
//        } else {
//          shipCount--; // if criterias are not met, try to deploy again at different random coordinates.
//        }
        if (x + 2 < GAME_BOARD_X && y + 2 < GAME_BOARD_Y) {
          gameBoard[x][y].getCell().setFill(Color.GRAY);
          gameBoard[x][y+1].getCell().setFill(Color.GRAY);
          gameBoard[x][y+2].getCell().setFill(Color.GRAY);
        } else {
          shipCount--;
        }

      } else {
        // If the cell is not valid, try again
        shipCount--; // Decrement the ship count to try placing the ship again
      }
    }
  }

  public void randomShot() {
    Random random = new Random();
    int shipsHit = 0;

    while (shipsHit < NUMBER_OF_SHIPS) {

      for (int tries = 0; tries < 1; tries++) {
        if (shipsHit == NUMBER_OF_SHIPS) {
          System.out.println("🥇🏆 Congratulations! 🏆🥇");
          break;
        } else {
          int x = random.nextInt(GAME_BOARD_X);
          int y = random.nextInt(GAME_BOARD_Y);


          // if coordinate already has been shot - do another try
          if (gameBoard[x][y].getCell().getFill() == Color.BLACK || gameBoard[x][y].getCell().getFill() == Color.RED) {
            tries--;
          }
          // if ship has been hit, get another try.
          else if (isShipHit(x, y)) {
            System.out.println(); // Linebreaker
            System.out.println("Shooting coordinates: (" + x + ", " + y + ")");

            gameBoard[x][y].getCell().setFill(Color.RED); // change cell to red
            System.out.println("Hit!");
            System.out.println("Opponent 💬: You sunk my Battleship!");
            shipsHit++; // count hits
            tries--; // new try
            // if shot misses and hits water
          } else if (isCellBlue(x, y)) {
            System.out.println(); // Linebreaker
            System.out.println("Shooting coordinates: (" + x + ", " + y + ")");

            gameBoard[x][y].getCell().setFill(Color.BLACK);
            System.out.println("Miss!");
          }
        }

      }
    }
  }

  // Check if ship is hit
  private boolean isShipHit(int x, int y) {
    return gameBoard[x][y].getCell().getFill() == Color.GRAY;
  }


  // Check if a cell has at least one blue cell next to it
  private boolean hasBlueNeighbor(int x, int y) {
    // Check if the cell has a blue neighbor in each corner
    // Top cell
    boolean topCell = isCellBlue(x, y - 1);
    // Left side
    boolean topLeftCell = isCellBlue(x - 1, y - 1);
    boolean leftCell = isCellBlue(x - 1, y);
    boolean bottomLeftCell = isCellBlue(x + 1, y - 1);
    // right side
    boolean upperRightCell = isCellBlue(x - 1, y + 1);
    boolean rightCell = isCellBlue(x + 1, y);
    boolean bottomRightCell = isCellBlue(x + 1, y + 1);
    // bottom
    boolean bottomCell = isCellBlue(x, y + 1);


    return topCell && topLeftCell && leftCell && bottomLeftCell && bottomCell && bottomRightCell && rightCell && upperRightCell;
  }

  // Check if a cell is blue(water)
  private boolean isCellBlue(int x, int y) {
    return (x >= 0 && x < GAME_BOARD_X && y >= 0 && y < GAME_BOARD_Y
        && gameBoard[x][y].getCell().getFill() == Color.BLUE);
  }
}
