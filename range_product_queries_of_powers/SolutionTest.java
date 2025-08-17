package range_product_queries_of_powers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

  private Solution sol;

  @BeforeEach
  void setup() {
    sol = new Solution();
  }

  @Test
  void example1() {
    assertArrayEquals(new int[] {2, 4, 64},
        sol.productQueries(15, new int[][] {{0, 1}, {2, 2}, {0, 3}}));
  }


  @Test
  void example2() {
    assertArrayEquals(new int[] {2}, sol.productQueries(2, new int[][] {{0, 0}}));
  }
}
