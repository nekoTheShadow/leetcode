package apple_redistribution_into_boxes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Gatherers;

public class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int total = Arrays.stream(apple).sum();
        long count = Arrays.stream(capacity)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .gather(Gatherers.scan(() -> 0, Integer::sum))
                .takeWhile(acc -> acc < total)
                .count();
        return (int) (count + 1);
    }
}
