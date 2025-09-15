package maximum_number_of_words_you_can_type;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

  Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void example1() {
    String text = "hello world";
    String brokenLetters = "ad";
    int output = 1;
    assertEquals(output, solution.canBeTypedWords(text, brokenLetters));
  }

  @Test
  void example2() {
    String text = "leet code";
    String brokenLetters = "lt";
    int output = 1;
    assertEquals(output, solution.canBeTypedWords(text, brokenLetters));
  }

  @Test
  void example3() {
    String text = "leet code";
    String brokenLetters = "e";
    int output = 0;
    assertEquals(output, solution.canBeTypedWords(text, brokenLetters));
  }

}
