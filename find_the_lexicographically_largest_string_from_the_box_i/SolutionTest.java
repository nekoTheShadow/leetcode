package find_the_lexicographically_largest_string_from_the_box_i;

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
    assertEquals("dbc", s.answerString("dbca", 2));
  }

  @Test
  void example2() {
    assertEquals("g", s.answerString("gggg", 4));
  }
  
  @Test
  void ng1() {
    assertEquals("if", s.answerString("bif", 2));
  }
  
  @Test
  void ng2() {
    assertEquals("nn", s.answerString("aann", 2));
  }
}
