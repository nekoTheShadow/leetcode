package remove_covered_intervals;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().removeCoveredIntervals(new int[][]{{1,4}, {3,6}, {2, 8}}));
        System.out.println(new Solution().removeCoveredIntervals(new int[][]{{1,4}, {2,3}}));
    }
    
    public int removeCoveredIntervals(int[][] intervals) {
        boolean[] removed = new boolean[intervals.length];
        
        for (int i = 0; i < intervals.length; i++) {
            if (removed[i]) continue;
            
            for (int j = 0; j < intervals.length; j++) {
                if (i == j || removed[j]) continue;
                
                int a = intervals[i][0];
                int b = intervals[i][1];
                int c = intervals[j][0];
                int d = intervals[j][1];
                if (c <= a && b <= d) removed[i] = true;
            }
        }
        
        int ans = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (!removed[i]) ans++;
        }
        return ans;
    }
}
