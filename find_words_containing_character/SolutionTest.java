package find_words_containing_character;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  public void setUp() {
    solution = new Solution();
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("testCases")
  public void parameterizedTests(String testName, String[] words, char x, List<Integer> expected) {
    List<Integer> actual = solution.findWordsContaining(words, x);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> testCases() {
    return Stream.of(Arguments.of("example1", new String[] {"leet", "code"}, 'e', List.of(0, 1)),
        Arguments.of("example2", new String[] {"abc", "bcd", "aaaa", "cbc"}, 'a', List.of(0, 2)),
        Arguments.of("example3", new String[] {"abc", "bcd", "aaaa", "cbc"}, 'z', List.of()));
  }
}
