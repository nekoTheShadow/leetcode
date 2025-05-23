package set_matrix_zeroes;

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
    int[][] input = new int[][] {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    int[][] output = new int[][] {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
    s.setZeroes(input);
    assertArrayEquals(output, input);
  }

  @Test
  void example2() {
    int[][] input = new int[][] {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
    int[][] output = new int[][] {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};
    s.setZeroes(input);
    assertArrayEquals(output, input);
  }

}
