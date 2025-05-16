package longest_unequal_adjacent_groups_subsequence_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
  public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
    int n = words.length;

    int[] dp = new int[n];
    Arrays.fill(dp, 1);

    int[] prev = new int[n];
    Arrays.fill(prev, -1);

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (isOK(words, groups, i, j) && dp[i] + 1 > dp[j]) {
          dp[j] = dp[i] + 1;
          prev[j] = i;
        }
      }
    }


    List<String> ret = new ArrayList<>();
    int cur = IntStream.range(0, n).boxed().max(Comparator.comparing(i -> dp[i])).get();
    while (cur != -1) {
      ret.add(words[cur]);
      cur = prev[cur];
    }
    Collections.reverse(ret);

    return ret;
  }

  private boolean isOK(String[] words, int[] groups, int i, int j) {
    // 隣り合う要素のgroupsの値は異なること
    if (groups[i] == groups[j]) {
      return false;
    }

    // 隣り合う要素の文字列長は同じであること
    if (words[i].length() != words[j].length()) {
      return false;
    }

    // 隣り合う要素の文字はちょうど1文字だけ違うこと
    return IntStream.range(0, words[i].length())
        .filter(x -> words[i].charAt(x) != words[j].charAt(x)).count() == 1;
  }
}
