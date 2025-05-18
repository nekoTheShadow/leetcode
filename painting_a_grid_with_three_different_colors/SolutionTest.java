package painting_a_grid_with_three_different_colors;

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
    assertEquals(3, s.colorTheGrid(1, 1));
  }
  
  @Test
  void example2() {
    assertEquals(6, s.colorTheGrid(1, 2));
  }

  
  @Test
  void example3() {
    assertEquals(580986, s.colorTheGrid(5, 5));
  }

}
