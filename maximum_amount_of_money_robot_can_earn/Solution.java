package maximum_amount_of_money_robot_can_earn;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {


    public int maximumAmount(int[][] coins) {
        int h = coins.length;
        int w = coins[0].length;
        int[][][] d = new int[h][w][3];
        for (int[][] matrix : d) {
            for (int[] row : matrix) {
                Arrays.fill(row, Integer.MIN_VALUE / 2);
            }
        }

        if (coins[0][0] >= 0) {
            d[0][0][0] = coins[0][0];
        } else {
            d[0][0][0] = coins[0][0];
            d[0][0][1] = 0;
        }

        for (int x = 0; x < h; x++) {
            for (int y = 0; y < w; y++) {
                if (x + 1 < h) {
                    d[x + 1][y][0] = Math.max(d[x + 1][y][0], d[x][y][0] + coins[x + 1][y]);
                    d[x + 1][y][1] = Math.max(d[x + 1][y][1], d[x][y][1] + coins[x + 1][y]);
                    d[x + 1][y][2] = Math.max(d[x + 1][y][2], d[x][y][2] + coins[x + 1][y]);
                    if (coins[x + 1][y] < 0) {
                        d[x + 1][y][1] = Math.max(d[x + 1][y][1], d[x][y][0]);
                        d[x + 1][y][2] = Math.max(d[x + 1][y][2], d[x][y][1]);
                    }
                }

                if (y + 1 < w) {
                    d[x][y + 1][0] = Math.max(d[x][y + 1][0], d[x][y][0] + coins[x][y + 1]);
                    d[x][y + 1][1] = Math.max(d[x][y + 1][1], d[x][y][1] + coins[x][y + 1]);
                    d[x][y + 1][2] = Math.max(d[x][y + 1][2], d[x][y][2] + coins[x][y + 1]);
                    if (coins[x][y + 1] < 0) {
                        d[x][y + 1][1] = Math.max(d[x][y + 1][1], d[x][y][0]);
                        d[x][y + 1][2] = Math.max(d[x][y + 1][2], d[x][y][1]);
                    }
                }
            }
        }

        int v1 = d[h - 1][w - 1][0];
        int v2 = d[h - 1][w - 1][1];
        int v3 = d[h - 1][w - 1][2];
        return IntStream.of(v1, v2, v3).max().getAsInt();
    }

}
