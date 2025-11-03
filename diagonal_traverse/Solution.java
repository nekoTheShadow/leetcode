package diagonal_traverse;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int h = mat.length;
        int w = mat[0].length;


        List<Integer> ans = new ArrayList<>();
        int sx = 0;
        int sy = 0;
        boolean up = true;

        while (ans.size() < h * w) {
            List<Integer> temp = new ArrayList<>();
            int x = sx, y = sy;
            while (0 <= x && x < h && 0 <= y && y < w) {
                temp.add(mat[x][y]);
                x--;
                y++;
            }
            if (up) {
                ans.addAll(temp);
            } else {
                ans.addAll(temp.reversed());
            }

            up = !up;
            if (sx == h - 1) {
                sy++;
            } else {
                sx++;
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
