package longest_unequal_adjacent_groups_subsequence_i;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<String> getLongestSubsequence(String[] words, int[] groups) {
    int group = -1;
    List<String> subsequence = new ArrayList<>();
    for (int i = 0, n = words.length; i < n; i++) {
      if (group != groups[i]) {
        subsequence.add(words[i]);
        group = groups[i];
      }
    }
    return subsequence;
  }
}
