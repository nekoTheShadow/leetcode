package two_city_scheduling;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().twoCitySchedCost(new int[][] {{10,20},{30,200},{400,50},{30,20}}));
        System.out.println(new Solution().twoCitySchedCost(new int[][] {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}}));
        System.out.println(new Solution().twoCitySchedCost(new int[][] {{515,563},{451,713},{537,709},{343,819},{855,779},{457,60},{650,359},{631,42}}));
    }
    
    public int twoCitySchedCost(int[][] costs) {
        this.n = costs.length/2;
        this.costs = costs;
        this.memo = new int[n*2][n+1][n+1];
        for (int[][] a : memo) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return f(0, 0, 0);
    }
    
    private int n;
    private int[][] costs;
    private int[][][] memo;
    
    public int f(int x, int a, int b) {
        if (x == n*2) {
            return 0;
        }
        
        if (memo[x][a][b] != -1) {
            return memo[x][a][b];
        }
        
        int ans;
        if (a==n) {
            ans = f(x+1, a, b+1) + costs[x][1];
        } else if (b==n) {
            ans = f(x+1, a+1, b) + costs[x][0];
        } else {
            int p = f(x+1, a, b+1) + costs[x][1];
            int q = f(x+1, a+1, b) + costs[x][0];
            ans = Math.min(p, q);
        }
        
        memo[x][a][b] = ans;
        return ans;
    }
}

