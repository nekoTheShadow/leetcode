package push_dominoes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

  Solution s;

  @BeforeEach
  void setUp() {
    s = new Solution();
  }

  @ParameterizedTest
  @CsvSource({"RR.L, RR.L", ".L.R...LR..L.., LL.RR.LLRRLL..",})
  void example(String input, String output) {
    assertEquals(output, s.pushDominoes(input));
  }

}
