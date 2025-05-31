package snakes_and_ladders;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void example1() {
    int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1},
        {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
    int expected = 4;
    int actual = solution.snakesAndLadders(board);
    assertEquals(expected, actual);
  }


  @Test
  void example2() {
    int[][] board = {{-1, -1}, {-1, 3}};
    int expected = 1;
    int actual = solution.snakesAndLadders(board);
    assertEquals(expected, actual);
  }
}
