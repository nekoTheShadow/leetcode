package maximum_value_of_an_ordered_triplet_ii;

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
    assertEquals(77, solution.maximumTripletValue(new int[] {12, 6, 1, 2, 7}));
  }

  @Test
  void example2() {
    assertEquals(133, solution.maximumTripletValue(new int[] {1, 10, 3, 4, 19}));
  }

  @Test
  void example3() {
    assertEquals(0, solution.maximumTripletValue(new int[] {1, 2, 3}));
  }
}
