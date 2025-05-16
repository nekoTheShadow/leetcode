package longest_unequal_adjacent_groups_subsequence_ii;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

  Solution s;

  @BeforeEach
  void setup() {
    s = new Solution();
  }

  @Test
  void example1() {
    check(new String[] {"bab", "cab"}, new int[] {1, 2, 2}, 2);
  }

  @Test
  void example2() {
    check(new String[] {"a", "b", "c", "d"}, new int[] {1, 2, 3, 4}, 4);
  }

  void check(String[] words, int[] groups, int length) {
    List<String> output = s.getWordsInLongestSubsequence(words, groups);

    assertEquals(length, output.size());

    for (int i = 0; i < output.size() - 1; i++) {
      String s1 = output.get(i);
      String s2 = output.get(i + 1);

      int x1 = IntStream.range(0, words.length).filter(x -> words[x] == s1).findFirst().getAsInt();
      int x2 = IntStream.range(0, words.length).filter(x -> words[x] == s2).findFirst().getAsInt();

      // s1 → s2 の順番であること
      assertTrue(x1 < x2);

      // 隣り合う要素のgroupsの値が異なること
      assertTrue(groups[x1] != groups[x2]);

      // 隣り合う要素の長さはおなじであること
      assertTrue(s1.length() == s2.length());

      // 隣り合う要素は1文字違いであること
      assertTrue(
          IntStream.range(0, s1.length()).filter(x -> s1.charAt(x) != s2.charAt(x)).count() == 1);
    }
  }

}
