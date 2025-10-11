package maximum_total_damage_with_spell_casting.maximum_total_damage_with_spell_casting;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private List<Tuple> tuples;
    private Map<Integer, Long> memo;

    public long maximumTotalDamage(int[] power) {
        tuples = Arrays.stream(power)
                .boxed()
                .collect(Collectors.groupingBy(Long::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .sorted(Comparator.comparing(Tuple::power))
                .toList();
        memo = new HashMap<>();
        return dp(0);
    }

    private long dp(int cur) {
        int n = tuples.size();
        if (cur == n) {
            return 0;
        }

        if (memo.get(cur) instanceof Long v) {
            return v;
        }

        // 採用しない
        long v1 = dp(cur + 1);

        // 採用する
        int nxt = cur + 1;
        while (nxt < n && tuples.get(nxt).power() - tuples.get(cur).power() <= 2) {
            nxt++;
        }
        long v2 = tuples.get(cur).power() * tuples.get(cur).count() + dp(nxt);

        long v = Math.max(v1, v2);
        memo.put(cur, v);
        return v;
    }
}

record Tuple(long power, long count) {

}

record Key(int cur, int pre) {

}