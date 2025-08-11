package fruits_into_baskets_iii;

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
    int[] fruits = new int[] {4, 2, 5};
    int[] baskets = new int[] {3, 5, 4};
    int output = 1;
    assertEquals(output, sol.numOfUnplacedFruits(fruits, baskets));
  }


  @Test
  void example2() {
    int[] fruits = new int[] {3, 6, 1};
    int[] baskets = new int[] {6, 4, 7};
    int output = 0;
    assertEquals(output, sol.numOfUnplacedFruits(fruits, baskets));
  }
}
