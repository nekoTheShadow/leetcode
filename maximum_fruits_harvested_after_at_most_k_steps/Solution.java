package maximum_fruits_harvested_after_at_most_k_steps;

public class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = 200000;
        int[] s = new int[n+2];
        int[] t = new int[n+2];
        for (int[] fruit : fruits) t[fruit[0]] += fruit[1];
        for (int i = 0; i <= n; i++) s[i+1] += s[i] + t[i];
        
        int ans = Integer.MIN_VALUE;
        
        // startPos -> left -> startPos -> right
        for (int l = 0; l <= k; l++) {
            int r = Math.max(0, k - l*2);
            int left = Math.max(0, startPos-l);
            int right = Math.min(n, startPos+r);
            ans = Math.max(ans, s[right+1]-s[left]);
        }
        
        // startPos -> right -> startPos -> left
        for (int r = 0; r <= k; r++) {
            int l = Math.max(0, k-r*2);
            int left = Math.max(0, startPos-l);
            int right = Math.min(n, startPos+r);
            ans = Math.max(ans, s[right+1]-s[left]);
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxTotalFruits(new int[][]{{2,8},{6,3},{8,6}}, 5, 4));
        System.out.println(new Solution().maxTotalFruits(new int[][]{{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}}, 5, 4));
        System.out.println(new Solution().maxTotalFruits(new int[][]{{0,3},{6,4},{8,5}}, 3, 2));
        System.out.println(new Solution().maxTotalFruits(new int[][]{{0, 10000}}, 20000, 20000));
        System.out.println(new Solution().maxTotalFruits(new int[][]{{200000,10000}}, 200000, 200000));
    }
}
