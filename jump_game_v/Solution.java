package jump_game_v;

import java.util.stream.IntStream;

public class Solution {
    public int maxJumps(int[] arr, int d) {
        return new Solver(arr, d).solve();
    }


    private static final class Solver {
        private int[] arr;
        private int d;
        private int n;
        private int[] memo;

        public Solver(int[] arr, int d) {
            this.arr = arr;
            this.d = d;
            this.n = arr.length;
            this.memo = new int[n];
        }

        public int solve() {
            return IntStream.range(0, n).map(i -> f(i)).max().getAsInt();
        }

        private int f(int x) {
            if (memo[x] != 0) {
                return memo[x];
            }

            int ans = 1;
            for (int i = x+1; i <= Math.min(n-1, x+d); i++) {
                if (arr[x] <= arr[i]) break;
                ans = Math.max(ans, f(i)+1);
            }

            for (int i = x-1; i >= Math.max(0, x-d); i--) {
                if (arr[x] <= arr[i]) break;
                ans = Math.max(ans, f(i)+1);
            }

            memo[x] = ans;
            return ans;
        }
    }
}
