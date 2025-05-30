package mmaximize_the_number_of_target_nodes_after_connecting_trees_ii;

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
    int[] expected = {8, 7, 7, 8, 8};
    assertArrayEquals(expected, solution.maxTargetNodes(edges1, edges2));
  }

  @Test
  public void example2() {
    int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {0, 4}};
    int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}};
    int[] expected = {3, 6, 6, 6, 6};
    assertArrayEquals(expected, solution.maxTargetNodes(edges1, edges2));
  }

  @Test
  public void ng1() {
    int[][] edges1 = {{2, 1}, {7, 3}, {0, 4}, {7, 5}, {2, 6}, {0, 2}, {0, 7}};
    int[][] edges2 = {{3, 0}, {1, 2}, {5, 1}, {6, 3}, {9, 4}, {5, 6}, {7, 5}, {9, 7}, {8, 9}};
    int[] expected = {11, 11, 9, 11, 9, 11, 11, 9};
    assertArrayEquals(expected, solution.maxTargetNodes(edges1, edges2));
  }
}
