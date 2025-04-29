package count_subarrays_where_max_element_appears_at_least_k_times;

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
    assertEquals(6, s.countSubarrays(new int[] {1, 3, 2, 3, 3}, 2));
  }


  @Test
  void example2() {
    assertEquals(0, s.countSubarrays(new int[] {1, 4, 2, 1}, 3));
  }
}
