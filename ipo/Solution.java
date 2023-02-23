package ipo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        var projects = IntStream.range(0, n)
                                .mapToObj(i -> new int[] {profits[i], capital[i]})
                                .sorted(Comparator.comparing(a -> a[1]))
                                .toArray(int[][]::new);
        int i = 0;
        var pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        while (k > 0) {
            while (i < n && projects[i][1] <= w) {
                pq.add(projects[i][0]);
                i++;
            }
            if (!pq.isEmpty()) {
                w += pq.remove();
            }
            k--;
        }
        
        return w;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMaximizedCapital(2, 0, new int[] {1,2,3}, new int[] {0,1,1}));
        System.out.println(new Solution().findMaximizedCapital(3, 0, new int[] {1,2,3}, new int[] {0,1,2}));
    }
}
