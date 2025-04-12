package find_the_count_of_good_integers;

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
    assertEquals(27, solution.countGoodIntegers(3, 5));
  }

  @Test
  void example2() {
    assertEquals(2, solution.countGoodIntegers(1, 4));
  }
  
  @Test
  void example3() {
    assertEquals(2468, solution.countGoodIntegers(5, 6));
  }

  @Test
  void ng1() {
    assertEquals(41457024, solution.countGoodIntegers(10, 1));
  }
}
