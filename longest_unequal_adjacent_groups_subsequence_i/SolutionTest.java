package longest_unequal_adjacent_groups_subsequence_i;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

  Solution s;

  @BeforeEach
  void setUp() {
    s = new Solution();
  }

  @Test
  void example1() {
    List<String> actual =
        s.getLongestSubsequence(new String[] {"e", "a", "b"}, new int[] {0, 0, 1});
    assertEquals(List.of("e", "b"), actual);
  }


  @Test
  void example2() {
    List<String> actual =
        s.getLongestSubsequence(new String[] {"a", "b", "c", "d"}, new int[] {1, 0, 1, 1});
    assertEquals(List.of("a", "b", "c"), actual);
  }
}
