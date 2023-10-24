package battleship;

import battleship.data.Map;
import battleship.data.ShipUtil;

import java.util.Random;

public class Game {
  public void start() {
    Map.create();
    ShipUtil.deployRandomShips(1);
    Map.print(1);
    ShipUtil.deployRandomShips(2);
    Map.print(2);


    int currentPlayer = 1;


    while (!Map.isGameOver()) {
      Random random = new Random();
      System.out.println("Player " + currentPlayer + ", it's your turn.");
      int x = random.nextInt(10)+1;

      int y = random.nextInt(10)+1;
      System.out.print("Entering coordinates (X, Y): (" + x + ", " + y + ")");


      if (Map.makeShot(currentPlayer, x - 1, y - 1)) {
        System.out.println("You hit a ship!");
      } else {
        System.out.println("You missed.");
      }

      Map.print(currentPlayer);
      currentPlayer = (currentPlayer == 1) ? 2 : 1;
    }

    int winner = (currentPlayer == 1) ? 2 : 1;
    System.out.println("Player " + winner + " wins! Congratulations!");
  }
}
