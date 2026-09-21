package find_x_value_of_array_i;

public class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] dp = new long[k];
        long[] ret = new long[k];

        for (int num : nums) {
            long[] ndp = new long[k];
            ndp[num % k]++;

            for (int rem = 0; rem < k; rem++) {
                ndp[(int) (((long) rem * num) % k)] += dp[rem];
            }
            dp = ndp;

            for (int rem = 0; rem < k; rem++) {
                ret[rem] += dp[rem];
            }
        }

        return ret;
    }
}
