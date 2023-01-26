package cheapest_flights_within_k_stops;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> g = IntStream.range(0, n).mapToObj(unused -> new ArrayList<int[]>()).collect(Collectors.toList());
        for (int[] flight : flights) {
            g.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }
        
        int inf = Integer.MAX_VALUE / 2 - 1;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {src, k+1});
        int[][] score = new int[n][k+2];
        for (int[] row : score) {
            Arrays.fill(row, inf);
        }
        score[src][k+1] = 0;
        
        while (!q.isEmpty()) {
            int[] t = q.poll();
            if (t[1] == 0) {
                continue;
            }
            
            
            for (int[] e : g.get(t[0])) {
                if (score[t[0]][t[1]]+e[1] < score[e[0]][t[1]-1]) {
                    score[e[0]][t[1]-1] = score[t[0]][t[1]]+e[1];
                    q.add(new int[] {e[0], t[1]-1});
                }
            }
        }
        
        int ans = inf;
        for (int i = 0; i <= k+1; i++) {
            ans = Math.min(ans, score[dst][i]);
        }
        return ans == inf ? -1 : ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findCheapestPrice(4, new int[][] {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}}, 0, 3, 1));
        System.out.println(new Solution().findCheapestPrice(3, new int[][] {{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));
        System.out.println(new Solution().findCheapestPrice(3, new int[][] {{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 0));
    }
}
