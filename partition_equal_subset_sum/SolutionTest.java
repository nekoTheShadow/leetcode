package partition_equal_subset_sum;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

  Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void example1() {
    assertEquals(true, solution.canPartition(new int[] {1, 5, 11, 5}));
  }

  @Test
  void example2() {
    assertEquals(false, solution.canPartition(new int[] {1, 2, 3, 5}));
  }

  @Test
  void example3() {
    assertEquals(false, solution.canPartition(new int[] {1, 2, 5}));
  }
}
