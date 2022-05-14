package network_delay_time;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(new Solution2().networkDelayTime(new int[][] {{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
        System.out.println(new Solution2().networkDelayTime(new int[][] {{1,2,1}}, 2, 1));
        System.out.println(new Solution2().networkDelayTime(new int[][] {{1,2,1}}, 2, 2));
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> edges = IntStream.range(0, n).mapToObj(unused -> new ArrayList<int[]>()).collect(Collectors.toList());
        for (int[] time : times) {
            edges.get(time[0]-1).add(new int[] {time[1]-1, time[2]});
        }
        
        int[] score = new int[n];
        Arrays.fill(score, Integer.MAX_VALUE);
        score[k-1] = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(k-1);
        
        while (!stack.isEmpty()) {
            int cur = stack.removeLast();
            for (int[] time : edges.get(cur)) {
                if (score[cur] + time[1] < score[time[0]]) {
                    score[time[0]] = score[cur] + time[1];
                    stack.addLast(time[0]);
                }
            }
        }
        
        int ans = Arrays.stream(score).max().getAsInt();
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
