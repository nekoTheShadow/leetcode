package count_subarrays_with_score_less_than_k;

import static org.junit.jupiter.api.Assertions.*;
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
    assertEquals(6, s.countSubarrays(new int[] {2, 1, 4, 3, 5}, 10));
  }

  @Test
  void example2() {
    assertEquals(5, s.countSubarrays(new int[] {1, 1, 1}, 5));
  }
}
