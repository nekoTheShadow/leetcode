package total_characters_in_string_after_transformations_ii;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

  Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void example2() {
    String s = "azbk";
    int t = 1;
    List<Integer> nums =
        List.of(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
    int output = 8;
    assertEquals(output, solution.lengthAfterTransformations(s, t, nums));
  }


  @Test
  void example1() {
    String s = "abcyy";
    int t = 2;
    List<Integer> nums =
        List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2);
    int output = 7;
    assertEquals(output, solution.lengthAfterTransformations(s, t, nums));
  }

  @Test
  void ng1() {
    String s = "x";
    int t = 16;
    List<Integer> nums =
        List.of(6, 6, 8, 1, 9, 9, 10, 3, 9, 4, 8, 5, 2, 8, 10, 2, 6, 8, 2, 3, 3, 7, 2, 6, 4, 2);
    int output = 417796858;
    assertEquals(output, solution.lengthAfterTransformations(s, t, nums));
  }
}
