package minimum_difference_in_sums_after_removal_of_elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumDifference(new int[] {3,1,2}));
        System.out.println(new Solution().minimumDifference(new int[] {7,9,5,8,1,3}));
    }
    
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(Comparator.reverseOrder());
        long sum1 = 0;
        List<Long> sums1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sum1 += nums[i];
            pq1.add(nums[i]);
        }
        sums1.add(sum1);
        for (int i = 0; i < n; i++) {
            int x = pq1.poll();
            sum1 -= x;
            sum1 += Math.min(nums[i+n], x);
            pq1.add(Math.min(nums[i+n], x));
            sums1.add(sum1);
        }
        
        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(Comparator.naturalOrder());
        long sum2 = 0;
        List<Long> sums2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sum2 += nums[i+2*n];
            pq2.add(nums[i+2*n]);
        }
        sums2.add(sum2);
        for (int i = 0; i < n; i++) {
            int x = pq2.poll();
            sum2 -= x;
            sum2 += Math.max(nums[2*n-i-1], x);
            pq2.add(Math.max(nums[2*n-i-1], x));
            sums2.add(sum2);
        }
        Collections.reverse(sums2);
        
        return IntStream.range(0, n+1).mapToLong(i -> sums1.get(i) - sums2.get(i)).min().getAsLong();
    }
}
