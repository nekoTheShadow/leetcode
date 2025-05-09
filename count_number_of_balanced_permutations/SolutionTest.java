package count_number_of_balanced_permutations;

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
    assertEquals(2, s.countBalancedPermutations("123"));
  }

  
  @Test
  void example2() {
    assertEquals(1, s.countBalancedPermutations("112"));
  }

  @Test
  void example3() {
    assertEquals(0, s.countBalancedPermutations("12345"));
  }
}
