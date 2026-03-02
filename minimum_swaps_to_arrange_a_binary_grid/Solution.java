package minimum_swaps_to_arrange_a_binary_grid;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] counts = Arrays.stream(grid).mapToInt(row -> count(row, n)).toArray();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int required = n - i - 1;
            OptionalInt j = IntStream.range(i, n).filter(x -> required <= counts[x]).findFirst();
            if (j.isEmpty()) {
                return -1;
            }
            for (int k = j.getAsInt(); i < k; k--) {
                swap(counts, k - 1, k);
                ans++;
            }
        }

        return ans;
    }


    private int count(int[] row, int n) {
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (row[i] == 1) {
                break;
            }
            count++;
        }
        return count;
    }


    private void swap(int[] row, int x, int y) {
        int temp = row[x];
        row[x] = row[y];
        row[y] = temp;
    }
}
