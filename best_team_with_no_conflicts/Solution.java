package best_team_with_no_conflicts;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        n = scores.length;
        players = IntStream.range(0, n)
                           .mapToObj(i -> new int[] {scores[i], ages[i]})
                           .sorted(Comparator.<int[]>comparingInt(a -> a[1]).thenComparingInt(a -> a[0]))
                           .collect(Collectors.toList());
        memo = new HashMap<>();
        return  IntStream.range(0, n).map(this::dfs).max().getAsInt();
    }
    
    private int n;
    private List<int[]> players;
    private Map<Integer, Integer> memo;
    
    public int dfs(int i) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        
        int max = players.get(i)[0];
        for (int j = i+1; j < n; j++) {
            if (players.get(i)[0] <= players.get(j)[0]) {
                max = Math.max(max, players.get(i)[0] + dfs(j));
            }
        }
        memo.put(i, max);
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().bestTeamScore(new int[] {1,3,5,10,15}, new int[] {1,2,3,4,5}));
        System.out.println(new Solution().bestTeamScore(new int[] {4,5,6,5}, new int[] {2,1,2,1}));
        System.out.println(new Solution().bestTeamScore(new int[] {1,2,3,5}, new int[] {8,9,10,1}));
    }
}
