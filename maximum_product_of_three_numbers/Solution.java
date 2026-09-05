package maximum_product_of_three_numbers;

public class Solution {
    /**
     * def maximum_product(nums) = [nums.max(3), nums.min(2)+nums.max(1)].map{_1.reduce(:*)}.max
     */
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max1) {
                // num, max1, max2
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                // max1, num, max2;
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                // max1, max2, num
                max3 = num;
            }

            if (num < min1) {
                // num, min1;
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                // min1, num
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}
