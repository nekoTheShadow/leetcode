package maximum_unique_subarray_sum_after_deletion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

  Solution solution;
  
  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void example1() {
    int[] nums = {1,2,3,4,5};
    int output = 15;
    assertEquals(solution.maxSum(nums), output);
  }

  @Test
  void example2() {
    int[] nums = {1,1,0,1,1};
    int output = 1;
    assertEquals(solution.maxSum(nums), output);
  }
  
  @Test
  void example3() {
    int[] nums = {1,2,-1,-2,1,0,-1};
    int output = 3;
    assertEquals(solution.maxSum(nums), output);
  }
}
