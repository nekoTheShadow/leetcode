package count_subarrays_of_length_three_with_a_condition;

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
    assertEquals(1, s.countSubarrays(new int[] {1, 2, 1, 4, 1}));
  }

  @Test
  void example2() {
    assertEquals(0, s.countSubarrays(new int[] {1, 1, 1}));
  }
}
