package kth_smallest_element_in_a_sorted_matrix;

import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] ptrs = new int[n];
        
        int ans = -1;
        while (k-- > 0) {
            int x = IntStream.range(0, n)
                             .boxed()
                             .filter(i -> ptrs[i] < matrix[i].length)
                             .min(Comparator.comparingInt(i -> matrix[i][ptrs[i]]))
                             .get();
            ans = matrix[x][ptrs[x]];
            ptrs[x]++;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8));
        System.out.println(new Solution().kthSmallest(new int[][]{{-5}}, 1));
    }
}
