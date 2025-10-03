package find_triangular_sum_of_an_array;

public class Solution {
    public int triangularSum(int[] nums) {
        for (int n = nums.length; n > 1; n--) {
            for (int i = 0; i < n - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }
        return nums[0];
    }
}