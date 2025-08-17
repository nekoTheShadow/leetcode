package ways_to_express_an_integer_as_sum_of_powers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

  Solution sol;
  
  @BeforeEach
  void setup() {
    sol = new Solution();
  }

  @Test
  void example1() {
    assertEquals(1, sol.numberOfWays(10, 2));
  }
  
  @Test
  void example2() {
    assertEquals(2, sol.numberOfWays(4, 1));
  }
  
  @Test
  void ng1() {
    assertEquals(400801751, sol.numberOfWays(261, 1));
  }
  
  @Test
  void ng2() {
    assertEquals(520706283, sol.numberOfWays(234, 1));
  }
  
  
  @Test
  void ng3() {
    assertEquals(1, sol.numberOfWays(1, 4));
  }
}
