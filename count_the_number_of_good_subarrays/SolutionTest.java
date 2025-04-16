package count_the_number_of_good_subarrays;

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
    assertEquals(1, s.countGood(new int[] {1, 1, 1, 1, 1}, 10));
  }

  
  @Test
  void example2() {
    assertEquals(4, s.countGood(new int[] {3,1,4,3,2,2,4}, 2));
  }
}
