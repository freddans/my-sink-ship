package battleship;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Game {
  public static int GAME_BOARD_X = 10;
  public static int GAME_BOARD_Y = 10;
  private static int NUMBER_OF_SHIPS = 3;
  private int nrOfShipColumns = 0;
  public static CellInfo[][] gameBoard = new CellInfo[GAME_BOARD_X][GAME_BOARD_Y];

  // Constructor
  public static class CellInfo {
    private Rectangle cell = new Rectangle(30, 30, Color.BLUE); // Initialize with a white rectangle

    public CellInfo() {
      cell.setStroke(Color.BLACK); // Color borders of cell
    }

    public Rectangle getCell() {
      return cell;
    }
  }

  // initialize map
  public void initializeGameBoard() {
    for (int i = 0; i < GAME_BOARD_X; i++) {
      for (int j = 0; j < GAME_BOARD_Y; j++) {
        gameBoard[i][j] = new CellInfo();
      }
    }
  }

  // place random ship
  public void deployShips() {

    int numberOfShips = 10;
    int fiveShips = 0;
    int fourShips = 0;
    int threeShips = 0;
    int twoShips = 0;

    while (numberOfShips > 0) {
      Random random = new Random();
      int randomNr = random.nextInt(4) + 2;

      if (twoShips != 4) {
        if (randomNr == 2) {
          int vertOrHorizontal = random.nextInt(2) + 1;

          if (vertOrHorizontal == 1) {
            placeShipsVertical(1, 2);
            numberOfShips--;
            twoShips++;
          } else if (vertOrHorizontal == 2) {
            placeShipsHorizontal(1, 2);
            numberOfShips--;
            twoShips++;
          }
        }
      }
      if (threeShips != 3) {
        if (randomNr == 3) {
          int vertOrHorizontal = random.nextInt(2) + 1;

          if (vertOrHorizontal == 1) {
            placeShipsVertical(1, 3);
            numberOfShips--;
            threeShips++;
          } else if (vertOrHorizontal == 2) {
            placeShipsHorizontal(1, 3);
            numberOfShips--;
            threeShips++;
          }
        }
      }
      if (fourShips != 2) {
        if (randomNr == 4) {
          int vertOrHorizontal = random.nextInt(2) + 1;

          if (vertOrHorizontal == 1) {
            placeShipsVertical(1, 4);
            numberOfShips--;
            fourShips++;
          } else if (vertOrHorizontal == 2) {
            placeShipsHorizontal(1, 4);
            numberOfShips--;
            fourShips++;
          }
        }
      }
      if (fiveShips != 1) {
        if (randomNr == 5) {
          int vertOrHorizontal = random.nextInt(2) + 1;

          if (vertOrHorizontal == 1) {
            placeShipsVertical(1, 5);
            numberOfShips--;
            fiveShips++;
          } else if (vertOrHorizontal == 2) {
            placeShipsHorizontal(1, 5);
            numberOfShips--;
            fiveShips++;
          }
        }
      }
    }
  }

  // vertical placement
  public void placeShipsVertical(int numShips, int nrOfCells) {
    if (nrOfCells == 2) {
      Random random = new Random();
      for (int shipCount = 0; shipCount < numShips; shipCount++) {
        int x = random.nextInt(GAME_BOARD_X);
        int y = random.nextInt(GAME_BOARD_Y);

        System.out.println("2 ship coords: (x" + x + ", y" + y + ")");

        if (x + 1 < GAME_BOARD_X && y < GAME_BOARD_Y) {
          if (isCellBlue(x, y) && isCellBlue(x + 1, y)) { // becomes ship
            if (twoBlueCheckVertical(x, y)) {
              gameBoard[x][y].getCell().setFill(Color.GRAY);
              gameBoard[x + 1][y].getCell().setFill(Color.GRAY);

              nrOfShipColumns += 2; // adding columnds for shot method

            } else { // if blues arent neighboring, get free spin
              shipCount--;
              System.out.println("free turn inside");
            }
          } else { // if ship cant be created - get free spin
            shipCount--;
            placeShipsHorizontal(shipCount, 2);
          }
        } else { // if outside of span - free spin
          shipCount--;
          System.out.println("Free turn in the end");
        }
      }
    } else if (nrOfCells == 3) {
      Random random = new Random();
      for (int shipCount = 0; shipCount < numShips; shipCount++) {
        int x = random.nextInt(GAME_BOARD_X);
        int y = random.nextInt(GAME_BOARD_Y);

        System.out.println("3 ship coords: (x" + x + ", y" + y + ")");

        if (x + 2 < GAME_BOARD_X && y < GAME_BOARD_Y) {
          if (isCellBlue(x, y) && isCellBlue(x + 1, y) && isCellBlue(x + 2, y)) { // becomes ship
            if (threeBlueCheckVertical(x, y)) {
              gameBoard[x][y].getCell().setFill(Color.GRAY);
              gameBoard[x + 1][y].getCell().setFill(Color.GRAY);
              gameBoard[x + 2][y].getCell().setFill(Color.GRAY);

              nrOfShipColumns += 3; // adding columnds for shot method

            } else { // if blues arent neighboring, get free spin
              shipCount--;
              System.out.println("free turn inside");
            }
          } else { // if ship cant be created - get free spin
            shipCount--;
            placeShipsHorizontal(shipCount, 3);
          }
        } else { // if outside of span - free spin
          shipCount--;
          System.out.println("Free turn in the end");
        }
      }
    } else if (nrOfCells == 4) {
      Random random = new Random();
      for (int shipCount = 0; shipCount < numShips; shipCount++) {
        int x = random.nextInt(GAME_BOARD_X);
        int y = random.nextInt(GAME_BOARD_Y);

        System.out.println("4 ship coords: (x" + x + ", y" + y + ")");

        if (x + 3 < GAME_BOARD_X && y < GAME_BOARD_Y) {
          if (isCellBlue(x, y) && isCellBlue(x + 1, y) && isCellBlue(x + 2, y) && isCellBlue(x + 3, y)) { // becomes ship
            if (fourBlueCheckVertical(x, y)) {
              gameBoard[x][y].getCell().setFill(Color.GRAY);
              gameBoard[x + 1][y].getCell().setFill(Color.GRAY);
              gameBoard[x + 2][y].getCell().setFill(Color.GRAY);
              gameBoard[x + 3][y].getCell().setFill(Color.GRAY);

              nrOfShipColumns += 4; // adding columnds for shot method

            } else { // if blues arent neighboring, get free spin
              shipCount--;
              System.out.println("free turn inside");
            }
          } else { // if ship cant be created - get free spin
            shipCount--;
            placeShipsHorizontal(shipCount, 4); // place horizontal
          }
        } else { // if outside of span - free spin
          shipCount--;
          System.out.println("Free turn in the end");
        }
      }
    } else if (nrOfCells == 5) {
      Random random = new Random();
      for (int shipCount = 0; shipCount < numShips; shipCount++) {
        int x = random.nextInt(GAME_BOARD_X);
        int y = random.nextInt(GAME_BOARD_Y);

        System.out.println("5 ship coords: (x" + x + ", y" + y + ")");

        if (x + 4 < GAME_BOARD_X && y < GAME_BOARD_Y) {
          if (isCellBlue(x, y) && isCellBlue(x + 1, y) && isCellBlue(x + 2, y) && isCellBlue(x + 3, y) && isCellBlue(x + 4, y)) { // becomes ship
            if (fiveBlueCheckVertical(x, y)) {
              gameBoard[x][y].getCell().setFill(Color.GRAY);
              gameBoard[x + 1][y].getCell().setFill(Color.GRAY);
              gameBoard[x + 2][y].getCell().setFill(Color.GRAY);
              gameBoard[x + 3][y].getCell().setFill(Color.GRAY);
              gameBoard[x + 4][y].getCell().setFill(Color.GRAY);

              nrOfShipColumns += 5; // adding columnds for shot method

            } else { // if blues arent neighboring, get free spin
              shipCount--;
              System.out.println("free turn inside");
            }
          } else { // if ship cant be created - get free spin
            shipCount--;
            placeShipsHorizontal(shipCount, 5);
          }
        } else { // if outside of span - free spin
          shipCount--;
          System.out.println("Free turn in the end");
        }
      }
    }
  }

  // horizontal placement
  public void placeShipsHorizontal(int numShips, int nrOfCells) {
    if (nrOfCells == 2) {
      Random random = new Random();
      for (int shipCount = 0; shipCount < numShips; shipCount++) {
        int x = random.nextInt(GAME_BOARD_X);
        int y = random.nextInt(GAME_BOARD_Y);

        System.out.println("2 ship coords: (x" + x + ", y" + y + ")");

        if (x < GAME_BOARD_X && y + 1 < GAME_BOARD_Y) {
          if (isCellBlue(x, y) && isCellBlue(x, y + 1)) { // becomes ship
            if (twoBlueCheckHorizontal(x, y)) {
              gameBoard[x][y].getCell().setFill(Color.GRAY);
              gameBoard[x][y + 1].getCell().setFill(Color.GRAY);

              nrOfShipColumns += 2; // adding columnds for shot method

            } else { // if blues arent neighboring, get free spin
              shipCount--;
              System.out.println("free turn inside");
            }
          } else { // if ship cant be created, get free spin
            shipCount--;
            placeShipsVertical(shipCount, 2);
          }
        } else { // if outside of span - free spin
          shipCount--;
          System.out.println("free turn in the end");
        }
      }
    } else if (nrOfCells == 3) {
      Random random = new Random();
      for (int shipCount = 0; shipCount < numShips; shipCount++) {
        int x = random.nextInt(GAME_BOARD_X);
        int y = random.nextInt(GAME_BOARD_Y);

        System.out.println("3 ship coords: (x" + x + ", y" + y + ")");

        if (x < GAME_BOARD_X && y + 2 < GAME_BOARD_Y) {
          if (isCellBlue(x, y) && isCellBlue(x, y + 1) && isCellBlue(x, y + 2)) { // becomes ship
            if (threeBlueCheckHorizontal(x, y)) {
              gameBoard[x][y].getCell().setFill(Color.GRAY);
              gameBoard[x][y + 1].getCell().setFill(Color.GRAY);
              gameBoard[x][y + 2].getCell().setFill(Color.GRAY);

              nrOfShipColumns += 3; // adding columnds for shot method

            } else { // if blues arent neighboring, get fre spin
              shipCount--;
              System.out.println("free turn inside");
            }
          } else { // if ship cant be created - free spin
            shipCount--;
            placeShipsVertical(shipCount, 3);
          }
        } else { // if outside of span - free spin
          shipCount--;
          System.out.println("Free turn in the end");
        }
      }
    } else if (nrOfCells == 4) {
      Random random = new Random();
      for (int shipCount = 0; shipCount < numShips; shipCount++) {
        int x = random.nextInt(GAME_BOARD_X);
        int y = random.nextInt(GAME_BOARD_Y);

        System.out.println("4 ship coords: (x" + x + ", y" + y + ")");

        if (x < GAME_BOARD_X && y + 3 < GAME_BOARD_Y) {
          if (isCellBlue(x, y) && isCellBlue(x, y + 1) && isCellBlue(x, y + 2) && isCellBlue(x, y + 3)) { // becomes ship
            if (fourBlueCheckHorizontal(x, y)) {
              gameBoard[x][y].getCell().setFill(Color.GRAY);
              gameBoard[x][y + 1].getCell().setFill(Color.GRAY);
              gameBoard[x][y + 2].getCell().setFill(Color.GRAY);
              gameBoard[x][y + 3].getCell().setFill(Color.GRAY);

              nrOfShipColumns += 4; // adding columnds for shot method

            } else { // if blues arent neighboring, get free spin
              shipCount--;
              System.out.println("free turn inside");
            }
          } else { // if ship cant be created - free spin
            shipCount--;
            placeShipsVertical(shipCount, 4);
          }
        } else { // if outside of span - free spin
          shipCount--;
          System.out.println("Free turn in the end");
        }
      }
    } else if (nrOfCells == 5) {
      Random random = new Random();
      for (int shipCount = 0; shipCount < numShips; shipCount++) {
        int x = random.nextInt(GAME_BOARD_X);
        int y = random.nextInt(GAME_BOARD_Y);

        System.out.println("5 ship coords: (x" + x + ", y" + y + ")");

        if (x < GAME_BOARD_X && y + 4 < GAME_BOARD_Y) {
          if (isCellBlue(x, y) && isCellBlue(x, y + 1) && isCellBlue(x, y + 2) && isCellBlue(x, y + 3) && isCellBlue(x, y + 4)) { // becomes ship
            if (fiveBlueCheckHorizontal(x, y)) {
              gameBoard[x][y].getCell().setFill(Color.GRAY);
              gameBoard[x][y + 1].getCell().setFill(Color.GRAY);
              gameBoard[x][y + 2].getCell().setFill(Color.GRAY);
              gameBoard[x][y + 3].getCell().setFill(Color.GRAY);
              gameBoard[x][y + 4].getCell().setFill(Color.GRAY);

              nrOfShipColumns += 5; // adding columnds for shot method

            } else { // if blues arent neighboring, get free spin
              shipCount--;
              System.out.println("free turn inside");
            }
          } else { // if ship cant be created - free spin
            shipCount--;
            placeShipsVertical(shipCount, 5);
          }
        } else { // if outside of span - free spin
          shipCount--;
          System.out.println("Free turn in the end");
        }
      }
    }
  }

  // new shoot method test
  public void shoot() {
    Random random = new Random();
    int x = random.nextInt(GAME_BOARD_X);
    int y = random.nextInt(GAME_BOARD_Y);

    if (!isCellGray(x, y)) {
      shoot();
    } else {

      // if shot misses
      if (isCellBlue(x, y)) {
        makeCellBlack(x, y);
        System.out.println("Initial Shot Missed at: (x" + x + ", y" + y + ")");
      } else if (isCellGray(x, y)) {
        makeCellRed(x, y);
        System.out.println("Initial Shot Hit at: (x" + x + ", y" + y + ")");
         aimRandomDirection(x, y);
      }
      else if (isCellRed(x, y) || isCellBlack(x, y)) {
        shoot();
      }
    }

  }

  public void followUpShot(int x, int y, Direction previousDirection) {

    if (isCellBlue(x, y)) {
      makeCellBlack(x, y);
      System.out.println("Follow Up Shot Missed at: (x" + x + ", y" + y + ")");
    } else if (isCellGray(x, y)) {
      makeCellRed(x, y);
      System.out.println("Follow Up Shot Hit at: (x" + x + ", y" + y + ")");
      if (previousDirection == Direction.UP) {
        aimUp(x, y);
      } else if (previousDirection == Direction.RIGHT) {
        aimRight(x, y);
      } else if (previousDirection == Direction.DOWN) {
        aimDown(x, y);
      } else {
        aimLeft(x, y);
      }
    }
  }

  public void aimRandomDirection(int x, int y) {
    Random random = new Random();
    int randomNr = random.nextInt(4)+1;

    if (randomNr == 1) {
      aimUp(x, y);
    } else if (randomNr == 2) {
      aimRight(x, y);
    } else if (randomNr == 3) {
      aimDown(x, y);
    } else {
      aimLeft(x, y);
    }
  }

  public void aimUp(int x, int y) {
    if (x - 1 > -1 && !isCellRed(x - 1, y)) {
      x--;
      followUpShot(x, y, Direction.UP);
    } else {
      aimRandomDirection(x, y);
    }
  }

  public void aimRight(int x, int y) {
    if (y + 1 < 10 && !isCellRed(x, y + 1)) {
      y++;
      followUpShot(x, y, Direction.RIGHT);
    } else {
      aimRandomDirection(x, y);
    }
  }

  public void aimDown(int x, int y) {
    if (x + 1 < 10 && !isCellRed(x + 1, y)) {
      x++;
      followUpShot(x, y, Direction.DOWN);
    } else {
      aimRandomDirection(x, y);
    }
  }

  public void aimLeft(int x, int y) {
    if (y - 1 > -1 && !isCellRed(x, y - 1)) {
      y--;
      followUpShot(x, y, Direction.LEFT);
    } else {
      aimRandomDirection(x, y);
    }
  }

  // Check if ship is hit
  private boolean isShipHit(int x, int y) {
    return gameBoard[x][y].getCell().getFill() == Color.GRAY;
  }

  private boolean twoBlueCheckHorizontal(int x, int y) {
    // tops
    boolean topLeft = isCellBlue(x - 1, y - 1);
    boolean topOne = isCellBlue(x - 1, y);
    boolean topTwo = isCellBlue(x - 1, y + 1);
    boolean topThree = isCellBlue(x - 1, y + 2);
    // lefts
    boolean leftCell = isCellBlue(x, y - 1);
    // rights
    boolean twoShipRight = isCellBlue(x, y + 2);
    // bottom cells
    boolean bottomLeft = isCellBlue(x + 1, y - 1);
    boolean bottomOne = isCellBlue(x + 1, y);
    boolean bottomTwo = isCellBlue(x + 1, y + 1);
    boolean bottomThree = isCellBlue(x + 1, y + 2);

    if (x == 0 && y == 0) {
      if (bottomOne && bottomTwo && bottomThree && twoShipRight) {
        return bottomOne && bottomTwo && bottomThree && twoShipRight;
      }
    } else if (x == 0 && y > 0 && y < 8) {
      if (leftCell && bottomLeft && bottomOne && bottomTwo && bottomThree && twoShipRight) {
        return leftCell && bottomLeft && bottomOne && bottomTwo && bottomThree && twoShipRight;
      }
    } else if (x == 0 && y == 8) {
      if (leftCell && bottomLeft && bottomOne && bottomTwo) {
        return leftCell && bottomLeft && bottomOne && bottomTwo;
      }
    } else if (x > 0 && x < 9 && y == 0) {
      if (topOne && topTwo && topThree && twoShipRight && bottomThree && bottomTwo && bottomOne) {
        return true;
      }
    } else if (x > 0 && x < 9 && y > 0 && y < 8) {
      if (topOne && topTwo && topThree && twoShipRight && bottomThree && bottomTwo && bottomOne && bottomLeft && leftCell && topLeft) {
        return true;
      }
    } else if (x > 0 && x < 9 && y == 8) {
      if (bottomTwo && bottomOne && bottomLeft && leftCell && topLeft && topOne && topTwo) {
        return true;
      }
    } else if (x == 9 && y == 0) {
      if (topOne && topTwo && topThree && twoShipRight) {
        return true;
      }
    } else if (x == 9 && y > 0 && y < 8) {
      if (leftCell && topLeft && topOne && topTwo && topThree && twoShipRight) {
        return true;
      }
    } else if (x == 9 && y == 8) {
      if (leftCell && topLeft && topOne && topTwo) {
        return true;
      }
    }
    return false;
  }

  private boolean twoBlueCheckVertical(int x, int y) {
    // tops
    boolean topLeft = isCellBlue(x - 1, y - 1);
    boolean topOne = isCellBlue(x - 1, y);
    boolean topRight = isCellBlue(x - 1, y + 1);
    // rights
    boolean rightOne = isCellBlue(x, y + 1);
    boolean rightTwo = isCellBlue(x + 1, y + 1);
    // bottom cells
    boolean rightThree = isCellBlue(x + 2, y + 1);
    boolean twoShipBottom = isCellBlue(x + 2, y);
    boolean leftThree = isCellBlue(x + 2, y - 1);
    // lefts
    boolean leftTwo = isCellBlue(x + 1, y - 1);
    boolean leftOne = isCellBlue(x, y - 1);

    if (x == 0 && y == 0) { // Up left corner
      if (rightOne && rightTwo && rightThree && twoShipBottom) {
        return rightOne && rightTwo && rightThree && twoShipBottom;
      }
    } else if (x == 0 && y > 0 && y < 9) { // top mid
      if (leftOne && leftTwo && leftThree && twoShipBottom && rightThree && rightTwo && rightOne) {
        return true;
      }
    } else if (x == 0 && y == 9) { // up right corner
      if (leftOne && leftTwo && leftThree && twoShipBottom) {
        return true;
      }
    } else if (x > 0 && x < 8 && y == 0) { // left mid
      if (topOne && topRight && rightOne && rightTwo && rightThree && twoShipBottom) {
        return true;
      }
    } else if (x > 0 && x < 8 && y > 0 && y < 9) { // middle middle
      if (topLeft && topOne && topRight && rightOne && rightTwo && rightThree && twoShipBottom && leftThree && leftTwo && leftOne) {
        return true;
      }
    } else if (x > 0 && x < 8 && y == 9) { // right middle
      if (topOne && topLeft && leftOne && leftTwo && leftThree && twoShipBottom) {
        return true;
      }
    } else if (x == 8 && y == 0) { // bottom left corner
      if (topOne && topRight && rightOne && rightTwo) {
        return true;
      }
    } else if (x == 8 && y > 0 && y < 8) { // bottom middle
      if (leftTwo && leftOne && topLeft && topOne && topRight && rightOne && rightTwo) {
        return true;
      }
    } else if (x == 8 && y == 9) { // bottom right corner
      if (leftTwo && leftOne && topLeft && topOne) {
        return true;
      }
    }
    return false;
  }

  private boolean threeBlueCheckHorizontal(int x, int y) {
    // tops
    boolean topLeft = isCellBlue(x - 1, y - 1);
    boolean topOne = isCellBlue(x - 1, y);
    boolean topTwo = isCellBlue(x - 1, y + 1);
    boolean topThree = isCellBlue(x - 1, y + 2);
    boolean topFour = isCellBlue(x - 1, y + 3);
    // lefts
    boolean leftCell = isCellBlue(x, y - 1);
    // rights
    boolean threeShipRight = isCellBlue(x, y + 3);
    // bottom cells
    boolean bottomLeft = isCellBlue(x + 1, y - 1);
    boolean bottomOne = isCellBlue(x + 1, y);
    boolean bottomTwo = isCellBlue(x + 1, y + 1);
    boolean bottomThree = isCellBlue(x + 1, y + 2);
    boolean bottomFour = isCellBlue(x + 1, y + 3);


    if (x == 0 && y == 0) {
      if (bottomOne && bottomTwo && bottomThree && bottomFour && threeShipRight) {
        return true;
      }
    } else if (x == 0 && y > 0 && y < 7) {
      if (leftCell && bottomLeft && bottomOne && bottomTwo && bottomThree && bottomFour && threeShipRight) {
        return true;
      }
    } else if (x == 0 && y == 7) {
      if (leftCell && bottomLeft && bottomOne && bottomTwo && bottomThree) {
        return true;
      }
    } else if (x > 0 && x < 9 && y == 0) {
      if (topOne && topTwo && topThree && topFour && threeShipRight && bottomFour && bottomThree && bottomTwo && bottomOne) {
        return true;
      }
    } else if (x > 0 && x < 9 && y > 0 && y < 7) {
      if (topOne && topTwo && topThree && topFour && threeShipRight && bottomFour && bottomThree && bottomTwo && bottomOne && bottomLeft && leftCell && topLeft) {
        return true;
      }
    } else if (x > 0 && x < 9 && y == 7) {
      if (bottomThree && bottomTwo && bottomOne && bottomLeft && leftCell && topLeft && topOne && topTwo && topThree) {
        return true;
      }
    } else if (x == 9 && y == 0) {
      if (topOne && topTwo && topThree && topFour && threeShipRight) {
        return true;
      }
    } else if (x == 9 && y > 0 && y < 7) {
      if (leftCell && topLeft && topOne && topTwo && topThree && topFour && threeShipRight) {
        return true;
      }
    } else if (x == 9 && y == 7) {
      if (leftCell && topLeft && topOne && topTwo && topThree) {
        return true;
      }
    }
    return false;
  }

  private boolean threeBlueCheckVertical(int x, int y) {
    // tops
    boolean topLeft = isCellBlue(x - 1, y - 1);
    boolean topOne = isCellBlue(x - 1, y);
    boolean topRight = isCellBlue(x - 1, y + 1);
    // rights
    boolean rightOne = isCellBlue(x, y + 1);
    boolean rightTwo = isCellBlue(x + 1, y + 1);
    boolean rightThree = isCellBlue(x + 2, y + 1);
    // bottom cells
    boolean rightFour = isCellBlue(x + 3, y + 1);
    boolean threeShipBottom = isCellBlue(x + 3, y);
    boolean leftFour = isCellBlue(x + 3, y - 1);
    // lefts
    boolean leftThree = isCellBlue(x + 2, y - 1);
    boolean leftTwo = isCellBlue(x + 1, y - 1);
    boolean leftOne = isCellBlue(x, y - 1);

    if (x == 0 && y == 0) { // Up left corner
      if (rightOne && rightTwo && rightThree && rightFour && threeShipBottom) {
        return true;
      }
    } else if (x == 0 && y > 0 && y < 9) { // top mid
      if (leftOne && leftTwo && leftThree && leftFour && threeShipBottom && rightFour && rightThree && rightTwo && rightOne) {
        return true;
      }
    } else if (x == 0 && y == 9) { // up right corner
      if (leftOne && leftTwo && leftThree && leftFour && threeShipBottom) {
        return true;
      }
    } else if (x > 0 && x < 7 && y == 0) { // left mid
      if (topOne && topRight && rightOne && rightTwo && rightThree && rightFour && threeShipBottom) {
        return true;
      }
    } else if (x > 0 && x < 7 && y > 0 && y < 9) { // middle middle
      if (topLeft && topOne && topRight && rightOne && rightTwo && rightThree && rightFour && threeShipBottom && leftFour && leftThree && leftTwo && leftOne) {
        return true;
      }
    } else if (x > 0 && x < 7 && y == 9) { // right middle
      if (topOne && topLeft && leftOne && leftTwo && leftThree && leftFour && threeShipBottom) {
        return true;
      }
    } else if (x == 7 && y == 0) { // bottom left corner
      if (topOne && topRight && rightOne && rightTwo && rightThree) {
        return true;
      }
    } else if (x == 7 && y > 0 && y < 8) { // bottom middle
      if (leftThree && leftTwo && leftOne && topLeft && topOne && topRight && rightOne && rightTwo && rightThree) {
        return true;
      }
    } else if (x == 7 && y == 9) { // bottom right corner
      if (leftThree && leftTwo && leftOne && topLeft && topOne) {
        return true;
      }
    }
    return false;
  }

  private boolean fourBlueCheckHorizontal(int x, int y) {
    boolean topLeft = isCellBlue(x - 1, y - 1);
    boolean topOne = isCellBlue(x - 1, y);
    boolean topTwo = isCellBlue(x - 1, y + 1);
    boolean topThree = isCellBlue(x - 1, y + 2);
    boolean topFour = isCellBlue(x - 1, y + 3);
    boolean topFive = isCellBlue(x - 1, y + 4);

    // lefts
    boolean leftCell = isCellBlue(x, y - 1);
    // rights
    boolean fourShipRight = isCellBlue(x, y + 4);
    // bottom cells
    boolean bottomLeft = isCellBlue(x + 1, y - 1);
    boolean bottomOne = isCellBlue(x + 1, y);
    boolean bottomTwo = isCellBlue(x + 1, y + 1);
    boolean bottomThree = isCellBlue(x + 1, y + 2);
    boolean bottomFour = isCellBlue(x + 1, y + 3);
    boolean bottomFive = isCellBlue(x + 1, y + 4);


    if (x == 0 && y == 0) { // top left
      if (bottomOne && bottomTwo && bottomThree && bottomFour && bottomFive && fourShipRight) {
        return true;
      }
    } else if (x == 0 && y > 0 && y < 6) { // top mid
      if (leftCell && bottomLeft && bottomOne && bottomTwo && bottomThree && bottomFour && bottomFive && fourShipRight) {
        return true;
      }
    } else if (x == 0 && y == 6) { // top right
      if (leftCell && bottomLeft && bottomOne && bottomTwo && bottomThree && bottomFour) {
        return true;
      }
    } else if (x > 0 && x < 9 && y == 0) { // middle left side
      if (topOne && topTwo && topThree && topFour && topFive && fourShipRight && bottomFive && bottomFour && bottomThree && bottomTwo && bottomOne) {
        return true;
      }
    } else if (x > 0 && x < 9 && y > 0 && y < 6) { // middle middle
      if (topOne && topTwo && topThree && topFour && topFive && fourShipRight && bottomFive && bottomFour && bottomThree && bottomTwo && bottomOne && bottomLeft && leftCell && topLeft) {
        return true;
      }
    } else if (x > 0 && x < 9 && y == 6) { // middle right side
      if (bottomFour && bottomThree && bottomTwo && bottomOne && bottomLeft && leftCell && topLeft && topOne && topTwo && topThree && topFour) {
        return true;
      }
    } else if (x == 9 && y == 0) { // bottom left corner
      if (topOne && topTwo && topThree && topFour && topFive && fourShipRight) {
        return true;
      }
    } else if (x == 9 && y > 0 && y < 6) {
      if (leftCell && topLeft && topOne && topTwo && topThree && topFour && topFive && fourShipRight) {
        return true;
      }
    } else if (x == 9 && y == 6) {
      if (leftCell && topLeft && topOne && topTwo && topThree && topFour) {
        return true;
      }
    }
    return false;
  }

  private boolean fourBlueCheckVertical(int x, int y) {
    // tops
    boolean topLeft = isCellBlue(x - 1, y - 1);
    boolean topOne = isCellBlue(x - 1, y);
    boolean topRight = isCellBlue(x - 1, y + 1);
    // rights
    boolean rightOne = isCellBlue(x, y + 1);
    boolean rightTwo = isCellBlue(x + 1, y + 1);
    boolean rightThree = isCellBlue(x + 2, y + 1);
    boolean rightFour = isCellBlue(x + 3, y + 1);
    // bottom cells
    boolean rightFive = isCellBlue(x + 4, y + 1);
    boolean fourShipBottom = isCellBlue(x + 4, y);
    boolean leftFive = isCellBlue(x + 4, y - 1);
    // lefts
    boolean leftFour = isCellBlue(x + 3, y - 1);
    boolean leftThree = isCellBlue(x + 2, y - 1);
    boolean leftTwo = isCellBlue(x + 1, y - 1);
    boolean leftOne = isCellBlue(x, y - 1);

    if (x == 0 && y == 0) { // Up left corner
      if (rightOne && rightTwo && rightThree && rightFour && rightFive && fourShipBottom) {
        return true;
      }
    } else if (x == 0 && y > 0 && y < 9) { // top mid
      if (leftOne && leftTwo && leftThree && leftFour && leftFive && fourShipBottom && rightFive && rightFour && rightThree && rightTwo && rightOne) {
        return true;
      }
    } else if (x == 0 && y == 9) { // up right corner
      if (leftOne && leftTwo && leftThree && leftFour && leftFive && fourShipBottom) {
        return true;
      }
    } else if (x > 0 && x < 6 && y == 0) { // left mid
      if (topOne && topRight && rightOne && rightTwo && rightThree && rightFour && rightFive && fourShipBottom) {
        return true;
      }
    } else if (x > 0 && x < 6 && y > 0 && y < 9) { // middle middle
      if (topLeft && topOne && topRight && rightOne && rightTwo && rightThree && rightFour && rightFive && fourShipBottom && leftFive && leftFour && leftThree && leftTwo && leftOne) {
        return true;
      }
    } else if (x > 0 && x < 6 && y == 9) { // right middle
      if (topOne && topLeft && leftOne && leftTwo && leftThree && leftFour && leftFive && fourShipBottom) {
        return true;
      }
    } else if (x == 6 && y == 0) { // bottom left corner
      if (topOne && topRight && rightOne && rightTwo && rightThree && rightFour) {
        return true;
      }
    } else if (x == 6 && y > 0 && y < 8) { // bottom middle
      if (leftFour && leftThree && leftTwo && leftOne && topLeft && topOne && topRight && rightOne && rightTwo && rightThree && rightFour) {
        return true;
      }
    } else if (x == 6 && y == 9) { // bottom right corner
      if (leftFour && leftThree && leftTwo && leftOne && topLeft && topOne) {
        return true;
      }
    }
    return false;
  }

  private boolean fiveBlueCheckHorizontal(int x, int y) {
    boolean topLeft = isCellBlue(x - 1, y - 1);
    boolean topOne = isCellBlue(x - 1, y);
    boolean topTwo = isCellBlue(x - 1, y + 1);
    boolean topThree = isCellBlue(x - 1, y + 2);
    boolean topFour = isCellBlue(x - 1, y + 3);
    boolean topFive = isCellBlue(x - 1, y + 4);
    boolean topSix = isCellBlue(x - 1, y + 5);

    // lefts
    boolean leftCell = isCellBlue(x, y - 1);
    // rights
    boolean fiveShipRight = isCellBlue(x, y + 5);
    // bottom cells
    boolean bottomLeft = isCellBlue(x + 1, y - 1);
    boolean bottomOne = isCellBlue(x + 1, y);
    boolean bottomTwo = isCellBlue(x + 1, y + 1);
    boolean bottomThree = isCellBlue(x + 1, y + 2);
    boolean bottomFour = isCellBlue(x + 1, y + 3);
    boolean bottomFive = isCellBlue(x + 1, y + 4);
    boolean bottomSix = isCellBlue(x + 1, y + 5);


    if (x == 0 && y == 0) { // top left
      if (bottomOne && bottomTwo && bottomThree && bottomFour && bottomFive && bottomSix && fiveShipRight) {
        return true;
      }
    } else if (x == 0 && y > 0 && y < 5) { // top mid
      if (leftCell && bottomLeft && bottomOne && bottomTwo && bottomThree && bottomFour && bottomFive && bottomSix && fiveShipRight) {
        return true;
      }
    } else if (x == 0 && y == 5) { // top right
      if (leftCell && bottomLeft && bottomOne && bottomTwo && bottomThree && bottomFour && bottomFive) {
        return true;
      }
    } else if (x > 0 && x < 9 && y == 0) { // middle left side
      if (topOne && topTwo && topThree && topFour && topFive && topSix && fiveShipRight && bottomSix && bottomFive && bottomFour && bottomThree && bottomTwo && bottomOne) {
        return true;
      }
    } else if (x > 0 && x < 9 && y > 0 && y < 5) { // middle middle
      if (topOne && topTwo && topThree && topFour && topFive && topSix && fiveShipRight && bottomSix && bottomFive && bottomFour && bottomThree && bottomTwo && bottomOne && bottomLeft && leftCell && topLeft) {
        return true;
      }
    } else if (x > 0 && x < 9 && y == 5) { // middle right side
      if (bottomFive && bottomFour && bottomThree && bottomTwo && bottomOne && bottomLeft && leftCell && topLeft && topOne && topTwo && topThree && topFour && topFive) {
        return true;
      }
    } else if (x == 9 && y == 0) { // bottom left corner
      if (topOne && topTwo && topThree && topFour && topFive && topSix && fiveShipRight) {
        return true;
      }
    } else if (x == 9 && y > 0 && y < 5) {
      if (leftCell && topLeft && topOne && topTwo && topThree && topFour && topFive && topSix && fiveShipRight) {
        return true;
      }
    } else if (x == 9 && y == 5) {
      if (leftCell && topLeft && topOne && topTwo && topThree && topFour && topFive) {
        return true;
      }
    }
    return false;
  }

  private boolean fiveBlueCheckVertical(int x, int y) {
    // tops
    boolean topLeft = isCellBlue(x - 1, y - 1);
    boolean topOne = isCellBlue(x - 1, y);
    boolean topRight = isCellBlue(x - 1, y + 1);
    // rights
    boolean rightOne = isCellBlue(x, y + 1);
    boolean rightTwo = isCellBlue(x + 1, y + 1);
    boolean rightThree = isCellBlue(x + 2, y + 1);
    boolean rightFour = isCellBlue(x + 3, y + 1);
    boolean rightFive = isCellBlue(x + 4, y + 1);
    // bottom cells
    boolean rightSix = isCellBlue(x + 5, y + 1);
    boolean fiveShipBottom = isCellBlue(x + 5, y);
    boolean leftSix = isCellBlue(x + 5, y - 1);
    // lefts
    boolean leftFive = isCellBlue(x + 4, y - 1);
    boolean leftFour = isCellBlue(x + 3, y - 1);
    boolean leftThree = isCellBlue(x + 2, y - 1);
    boolean leftTwo = isCellBlue(x + 1, y - 1);
    boolean leftOne = isCellBlue(x, y - 1);

    if (x == 0 && y == 0) { // Up left corner
      if (rightOne && rightTwo && rightThree && rightFour && rightFive && rightSix && fiveShipBottom) {
        return true;
      }
    } else if (x == 0 && y > 0 && y < 9) { // top mid
      if (leftOne && leftTwo && leftThree && leftFour && leftFive && leftSix && fiveShipBottom && rightSix && rightFive && rightFour && rightThree && rightTwo && rightOne) {
        return true;
      }
    } else if (x == 0 && y == 9) { // up right corner
      if (leftOne && leftTwo && leftThree && leftFour && leftFive && leftSix && fiveShipBottom) {
        return true;
      }
    } else if (x > 0 && x < 5 && y == 0) { // left mid
      if (topOne && topRight && rightOne && rightTwo && rightThree && rightFour && rightFive && rightSix && fiveShipBottom) {
        return true;
      }
    } else if (x > 0 && x < 5 && y > 0 && y < 9) { // middle middle
      if (topLeft && topOne && topRight && rightOne && rightTwo && rightThree && rightFour && rightFive && rightSix && fiveShipBottom && leftSix && leftFive && leftFour && leftThree && leftTwo && leftOne) {
        return true;
      }
    } else if (x > 0 && x < 5 && y == 9) { // right middle
      if (topOne && topLeft && leftOne && leftTwo && leftThree && leftFour && leftFive && leftSix && fiveShipBottom) {
        return true;
      }
    } else if (x == 5 && y == 0) { // bottom left corner
      if (topOne && topRight && rightOne && rightTwo && rightThree && rightFour && rightFive) {
        return true;
      }
    } else if (x == 5 && y > 0 && y < 8) { // bottom middle
      if (leftFive && leftFour && leftThree && leftTwo && leftOne && topLeft && topOne && topRight && rightOne && rightTwo && rightThree && rightFour && rightFive) {
        return true;
      }
    } else if (x == 5 && y == 9) { // bottom right corner
      if (leftFive && leftFour && leftThree && leftTwo && leftOne && topLeft && topOne) {
        return true;
      }
    }
    return false;
  }

  // CHANGE COLOR
  private void makeCellBlack(int x, int y) {
    gameBoard[x][y].getCell().setFill(Color.BLACK);
  }

  private void makeCellRed(int x, int y) {
    gameBoard[x][y].getCell().setFill(Color.RED);
  }


  // CHECK CELLS COLOR

  // Check if a cell is blue(water)
  private boolean isCellBlue(int x, int y) {
    return (x >= 0 && x < GAME_BOARD_X && y >= 0 && y < GAME_BOARD_Y
        && gameBoard[x][y].getCell().getFill() == Color.BLUE);
  }

  // check if a cell is black(already hit miss)
  private boolean isCellBlack(int x, int y) {
    return (x >= 0 && x < GAME_BOARD_X && y >= 0 && y < GAME_BOARD_Y
        && gameBoard[x][y].getCell().getFill() == Color.BLACK);
  }

  // Check if a cell is red(hit ship)
  private boolean isCellRed(int x, int y) {
    return (x >= 0 && x < GAME_BOARD_X && y >= 0 && y < GAME_BOARD_Y
        && gameBoard[x][y].getCell().getFill() == Color.RED);
  }

  // Check if a cell is grey(non-hit ship)
  private boolean isCellGray(int x, int y) {
    return (x >= 0 && x < GAME_BOARD_X && y >= 0 && y < GAME_BOARD_Y
        && gameBoard[x][y].getCell().getFill() == Color.GRAY);
  }
}