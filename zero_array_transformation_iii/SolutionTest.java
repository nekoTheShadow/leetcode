package zero_array_transformation_iii;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

  private Solution sol;

  @BeforeEach
  void setUp() {
      sol = new Solution();
  }

  @Test
  void example1() {
      int[] nums = {2, 0, 2};
      int[][] queries = {{0, 2}, {0, 2}, {1, 1}};
      int expected = 1;
      assertEquals(expected, sol.maxRemoval(nums, queries));
  }

  @Test
  void example2() {
      int[] nums = {1, 1, 1, 1};
      int[][] queries = {{1, 3}, {0, 2}, {1, 3}, {1, 2}};
      int expected = 2;
      assertEquals(expected, sol.maxRemoval(nums, queries));
  }

  @Test
  void example3() {
      int[] nums = {1, 2, 3, 4};
      int[][] queries = {{0, 3}};
      int expected = -1;
      assertEquals(expected, sol.maxRemoval(nums, queries));
  }
}