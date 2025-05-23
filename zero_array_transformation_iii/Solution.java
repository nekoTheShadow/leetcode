package zero_array_transformation_iii;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
  public int maxRemoval(int[] nums, int[][] queries) {
    Arrays.sort(queries, Comparator.comparingInt(query -> query[0]));
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    int[] d = new int[nums.length + 1];
    int lvl = 0;
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      while (j < queries.length && queries[j][0] == i) {
        pq.add(queries[j][1]);
        j++;
      }
      lvl += d[i];
      while (nums[i] > lvl && !pq.isEmpty() && pq.peek() >= i) {
        d[pq.poll() + 1]--;
        lvl++;
      }
      if (nums[i] > lvl) {
        return -1;
      }
    }
    return pq.size();
  }
}
