package maximum_candies_you_can_get_from_boxes;

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
  public void example1() {
    int[] status = {1, 0, 1, 0};
    int[] candies = {7, 5, 4, 100};
    int[][] keys = {{}, {}, {1}, {}};
    int[][] containedBoxes = {{1, 2}, {3}, {}, {}};
    int[] initialBoxes = {0};

    int expected = 16;
    int actual = solution.maxCandies(status, candies, keys, containedBoxes, initialBoxes);
    assertEquals(expected, actual);
  }

  @Test
  public void example2() {
    int[] status = {1, 0, 0, 0, 0, 0};
    int[] candies = {1, 1, 1, 1, 1, 1};
    int[][] keys = {{1, 2, 3, 4, 5}, {}, {}, {}, {}, {}};
    int[][] containedBoxes = {{1, 2, 3, 4, 5}, {}, {}, {}, {}, {}};
    int[] initialBoxes = {0};

    int expected = 6;
    int actual = solution.maxCandies(status, candies, keys, containedBoxes, initialBoxes);
    assertEquals(expected, actual);
  }
}
