package battleship.data;

import java.util.Random;

public class ShipUtil {
  public static int battleShips = 5;
  public static Random random = new Random();
  public static int[] player1x = new int[battleShips];
  public static int[] player1y = new int[battleShips];
  public static int[] player2x = new int[battleShips];
  public static int[] player2y = new int[battleShips];

  public static void deployRandomShips(int player) {
    System.out.println("Player " + player + " - Deploying ships:");

    int[] x;
    int[] y;

    if (player == 1) {
      x = (player1x == null) ? new int[battleShips] : player1x;
      y = (player1y == null) ? new int[battleShips] : player1y;
    } else {
      x = (player2x == null) ? new int[battleShips] : player2x;
      y = (player2y == null) ? new int[battleShips] : player2y;
    }

    for (int i = 0; i < battleShips; ) {
      x[i] = random.nextInt(10);
      y[i] = random.nextInt(10);

      boolean overlapping = false;
      for (int j = 0; j < i; j++) {
        if (x[i] == x[j] && y[i] == y[j]) {
          overlapping = true;
          break;
        }
      }

      if (!overlapping) {
        Map.theMap[x[i]][y[i]] = "1️⃣ "; // Use 1️⃣ for player 1's ships
        System.out.println("#" + (i + 1) + " ship DEPLOYED at X: " + (x[i] + 1) + ", Y: " + (y[i] + 1));
        i++;
      }
    }
  }
}