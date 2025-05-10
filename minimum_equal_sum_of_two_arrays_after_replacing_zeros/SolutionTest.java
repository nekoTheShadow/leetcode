package minimum_equal_sum_of_two_arrays_after_replacing_zeros;

import static org.junit.jupiter.api.Assertions.*;
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
    assertEquals(12, s.minSum(new int[] {3, 2, 0, 1, 0}, new int[] {6, 5, 0}));
  }

  @Test
  void example2() {
    assertEquals(-1, s.minSum(new int[] {2, 0, 2, 0}, new int[] {1, 4}));
  }

}
