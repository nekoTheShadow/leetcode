package minimum_time_to_remove_all_cars_containing_illegal_goods;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumTime("1100101"));
        System.out.println(new Solution().minimumTime("0010"));
    }
    
    public int minimumTime(String s) {
        int m = Math.max(0, (int)MaximumSubarray.solve(s.chars().mapToLong(ch -> ch == '1' ? -1 : 1).toArray()).getSum());
        return s.length() - m;
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
