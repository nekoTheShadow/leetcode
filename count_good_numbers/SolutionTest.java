package count_good_numbers;

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
    assertEquals(5, s.countGoodNumbers(1));
  }

  @Test
  void example2() {
    assertEquals(400, s.countGoodNumbers(4));
  }

  @Test
  void example3() {
    assertEquals(564908303, s.countGoodNumbers(50));
  }
}
