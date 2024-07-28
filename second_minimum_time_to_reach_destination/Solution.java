package second_minimum_time_to_reach_destination;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            g.get(edge[0]-1).add(edge[1]-1);
            g.get(edge[1]-1).add(edge[0]-1);
        }
        
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        dist1[0] = 0;
        
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[] {0, 1} );
        while (!q.isEmpty()) {
            int[] top = q.removeFirst();
            int cur = top[0];
            int frq = top[1];
            
            int dist = frq == 1 ? dist1[cur] : dist2[cur];
            if ((dist/change)%2==1) {
                dist = change*(dist/change+1) + time;
            } else {
                dist = dist + time;
            }
            
            for (int nxt : g.get(cur)) {
                if (dist1[nxt] == -1) {
                    dist1[nxt] = dist;
                    q.add(new int[] {nxt, 1});
                } else if (dist2[nxt] == -1 && dist1[nxt] != dist) {
                    if (nxt == n-1) {
                        return dist;
                    }
                    
                    dist2[nxt] = dist;
                    q.add(new int[] {nxt, 2});
                }
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().secondMinimum(5, new int[][]{{1,2},{1,3},{1,4},{3,4},{4,5}}, 3, 5));
        System.out.println(new Solution().secondMinimum(2, new int[][]{{1,2}}, 3, 2));
    }
}
