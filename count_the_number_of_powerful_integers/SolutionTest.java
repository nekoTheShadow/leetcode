package count_the_number_of_powerful_integers;

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
    assertEquals(5, s.numberOfPowerfulInt(1, 6000, 4, "124"));
  }

  @Test
  void example2() {
    assertEquals(2, s.numberOfPowerfulInt(15, 215, 6, "10"));
  }

  @Test
  void example3() {
    assertEquals(0, s.numberOfPowerfulInt(1000, 2000, 4, "3000"));
  }

  @Test
  void example_ng1() {
    assertEquals(16135677999L, s.numberOfPowerfulInt(697662853, 11109609599885L, 6, "5"));
  }

  @Test
  void example_ng2() {
    assertEquals(15646653, s.numberOfPowerfulInt(163566007, 24775613339457L, 6, "30212"));
  }
}
