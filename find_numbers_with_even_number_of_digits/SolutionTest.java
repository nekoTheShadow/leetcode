package find_numbers_with_even_number_of_digits;

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
    assertEquals(2, s.findNumbers(new int[] {12, 345, 2, 6, 7896}));
  }

  @Test
  void example2() {
    assertEquals(1, s.findNumbers(new int[] {555, 901, 482, 1771}));
  }
}
