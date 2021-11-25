package maximum_subarray;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}) == 6);
        System.out.println(solution.maxSubArray(new int[] {1}) == 1);
        System.out.println(solution.maxSubArray(new int[] {5,4,-1,7,8}) == 23);
        System.out.println(solution.maxSubArray(new int[] {-1})==-1);
    }
    
    public int maxSubArray(int[] nums) {
        long[] array = Arrays.stream(nums).mapToLong(Long::valueOf).toArray();
        MaximumSubarray ms = MaximumSubarray.solve(array);
        return (int)ms.getSum();
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
