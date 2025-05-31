package maximize_the_number_of_target_nodes_after_connecting_trees_i;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {


  private Solution solution;

  @BeforeEach
  public void setUp() {
    solution = new Solution();
  }

  @Test
  public void example1() {
    int[][] edges1 = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
    int[][] edges2 = {{0, 1}, {0, 2}, {0, 3}, {2, 7}, {1, 4}, {4, 5}, {4, 6}};
    int k = 2;
    int[] expected = {9, 7, 9, 8, 8};
    assertArrayEquals(expected, solution.maxTargetNodes(edges1, edges2, k));
  }

  @Test
  public void example2() {
    int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {0, 4}};
    int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}};
    int k = 1;
    int[] expected = {6, 3, 3, 3, 3};
    assertArrayEquals(expected, solution.maxTargetNodes(edges1, edges2, k));
  }
}
