package count_complete_subarrays_in_an_array;

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
    assertEquals(4, s.countCompleteSubarrays(new int[] {1, 3, 1, 2, 2}));
  }

  @Test
  void example2() {
    assertEquals(10, s.countCompleteSubarrays(new int[] {5, 5, 5, 5}));
  }
}
