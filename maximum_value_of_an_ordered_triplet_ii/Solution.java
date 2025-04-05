package maximum_value_of_an_ordered_triplet_ii;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
  public long maximumTripletValue(int[] nums) {
    int n = nums.length;
    Long[] vals = Arrays.stream(nums).mapToObj(Long::valueOf).toArray(Long[]::new);

    TreeMap<Long, Long> l = IntStream.range(0, 1).mapToObj(i -> vals[i])
        .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
    TreeMap<Long, Long> r = IntStream.range(2, n).mapToObj(i -> vals[i])
        .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));

    long ret = Long.MIN_VALUE;
    for (int j = 1; j < n - 1; j++) {
      long lmax = l.lastKey();
      long rmax = r.lastKey();
      ret = Math.max(ret, (lmax - vals[j]) * rmax);

      l.put(vals[j], l.getOrDefault(vals[j], 0L) + 1);
      if (r.get(vals[j + 1]) == 1) {
        r.remove(vals[j + 1]);
      } else {
        r.put(vals[j + 1], r.get(vals[j + 1]) - 1);
      }
    }
    return Math.max(ret, 0);
  }
}
