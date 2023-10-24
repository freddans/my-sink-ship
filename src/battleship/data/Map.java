package battleship.data;

public class Map {
  public static int numRows = 10;
  public static int numCols = 10;
  static String[][] theMap = new String[numRows][numCols];

  public static void create() {
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        theMap[i][j] = " ";
      }
    }
  }

  public static void print(int currentPlayer) {
    for (int i = 0; i < numRows; i++) {
      if (i <= 0) {
        System.out.println("    1   2  3  4  5  6  7   8  9  10");
        System.out.println("    ⬇  ⬇ ⬇  ⬇ ⬇ ⬇  ⬇  ⬇ ⬇  ⬇");
      }
      if (i < 9) {
        System.out.print(" " + (i + 1) + "➡ ");
      } else {
        System.out.print((i + 1) + "➡ ");
      }
      for (int j = 0; j < numCols; j++) {
        boolean isShipLocation = false;
        for (int shipIndex = 0; shipIndex < ShipUtil.battleShips; shipIndex++) {
          if ((currentPlayer == 1 && ShipUtil.player1x[shipIndex] == i && ShipUtil.player1y[shipIndex] == j) ||
              (currentPlayer == 2 && ShipUtil.player2x[shipIndex] == i && ShipUtil.player2y[shipIndex] == j)) {
            String cellContent = (currentPlayer == 1) ? "1️⃣ " : "2️⃣ ";
            System.out.print(String.format("%3s", cellContent));
            isShipLocation = true;
            break;
          }
        }
        if (!isShipLocation) {
          System.out.print("🟦 ");
        }
      }
      System.out.println(" ⬅" + (i + 1));
    }
    System.out.println("    ⬆  ⬆ ⬆  ⬆ ⬆  ⬆ ⬆  ⬆ ⬆  ⬆");
    System.out.println("    1   2  3  4  5   6  7  8  9  10");
  }




  public static boolean makeShot(int currentPlayer, int x, int y) {
    if (x < 0 || x >= numRows || y < 0 || y >= numCols) {
      System.out.println("Invalid shot coordinates.");
      return false; // Invalid shot
    }

    boolean isHit = false;

    for (int shipIndex = 0; shipIndex < ShipUtil.battleShips; shipIndex++) {
      if ((currentPlayer == 1 && ShipUtil.player2x[shipIndex] == x && ShipUtil.player2y[shipIndex] == y) ||
          (currentPlayer == 2 && ShipUtil.player1x[shipIndex] == x && ShipUtil.player1y[shipIndex] == y)) {
        isHit = true;
        break;
      }
    }

    if (isHit) {
      // Player hit a ship
      if (theMap[x][y].contains("1️⃣ ")) {
        theMap[x][y] = "💥 ";
      }
    } else {
      // Missed
      if (theMap[x][y].contains("🟦 ")) {
        theMap[x][y] = "❌ ";
      }
    }

    return isHit;
  }




  public static boolean isGameOver() {
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        if (theMap[i][j].equals("1️⃣ ")) {
          // Player 1 still has ships remaining
          return false;
        } else if (theMap[i][j].equals("2️⃣ ")) {
          // Player 2 still has ships remaining
          return false;
        }
      }
    }
    return true; // No ships remaining, the game is over
  }
}
