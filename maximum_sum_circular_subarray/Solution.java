package maximum_sum_circular_subarray;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubarraySumCircular(new int[] {1,-2,3,-2}));
        System.out.println(new Solution().maxSubarraySumCircular(new int[] {5,-3,5}));
        System.out.println(new Solution().maxSubarraySumCircular(new int[] {-3,-2,-3}));
    }

    public int maxSubarraySumCircular(int[] nums) {
        MaximumSubarray ms1 = MaximumSubarray.solve(Arrays.stream(nums).mapToLong(x -> (long)x).toArray());
        long sum = Arrays.stream(nums).sum();
        MaximumSubarray ms2 = MaximumSubarray.solve(Arrays.stream(nums).mapToLong(x -> (long)-x).toArray());

        if (ms2.getStart() == 0 && ms2.getEnd() == nums.length-1) {
            return (int)ms1.getSum();
        } else {
            return (int)Math.max(ms1.getSum(), sum + ms2.getSum());
        }

    }


    public static class MaximumSubarray {
        public static MaximumSubarray solve(long[] array) {
            long bestSum = Long.MIN_VALUE;
            long currentSum = 0;

            int currentStart = 0;
            int bestStart = -1;
            int bestEnd = -1;

            for (int currentEnd = 0; currentEnd < array.length; currentEnd++) {
                if (currentSum < 0) {
                    currentStart = currentEnd;
                    currentSum = array[currentEnd];
                } else {
                    currentSum += array[currentEnd];
                }

                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    bestStart = currentStart;
                    bestEnd = currentEnd;
                }
            }

            MaximumSubarray maximumSubarray = new MaximumSubarray();
            maximumSubarray.sum = bestSum;
            maximumSubarray.start = bestStart;
            maximumSubarray.end = bestEnd;
            return maximumSubarray;
        }

        private MaximumSubarray() {}

        private long sum;
        private int start;
        private int end;

        public long getSum() {
            return sum;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}
