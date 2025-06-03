package maximum_candies_you_can_get_from_boxes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
    int total = 0;
    List<Integer> boxes = Arrays.stream(initialBoxes).boxed().toList();
    while (!boxes.isEmpty()) {
      boolean hasNext = false;
      List<Integer> nexts = new ArrayList<>();
      for (int box : boxes) {
        if (status[box] == 1) {
          total += candies[box];
          Arrays.stream(containedBoxes[box]).forEach(next -> nexts.add(next));
          Arrays.stream(keys[box]).forEach(key -> status[key] = 1);
          hasNext = true;
        } else {
          nexts.add(box);
        }
      }
      
      if (!hasNext) {
        break;
      }
      boxes = nexts;
    }
    return total;
  }
}
