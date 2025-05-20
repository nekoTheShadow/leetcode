package type_of_triangle;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SolutionTest {

  private Solution solution;

  @BeforeEach
  public void setUp() {
    solution = new Solution();
  }

  @Test
  public void testExample1() {
    int[] nums = {3, 3, 3};
    String expected = "equilateral";
    assertEquals(expected, solution.triangleType(nums));
  }

  @Test
  public void testExample2() {
    int[] nums = {3, 4, 5};
    String expected = "scalene";
    assertEquals(expected, solution.triangleType(nums));
  }
}
