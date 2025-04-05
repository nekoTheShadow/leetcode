package lowest_common_ancestor_of_deepest_leaves;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

  Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void example1() {
    TreeNode actual =
        solution.lcaDeepestLeaves(buildTree(new int[] {3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4}));
    TreeNode expected = buildTree(new int[] {2, 7, 4});
    assertTrue(isSameTree(actual, expected));
  }
  
  @Test
  void example2() {
    TreeNode actual =
        solution.lcaDeepestLeaves(buildTree(new int[] {1}));
    TreeNode expected = buildTree(new int[] {1});
    assertTrue(isSameTree(actual, expected));
  }

  @Test
  void example3() {
    TreeNode actual =
        solution.lcaDeepestLeaves(buildTree(new int[] {0,1,3,-1,2}));
    TreeNode expected = buildTree(new int[] {2});
    assertTrue(isSameTree(actual, expected));
  }


  private TreeNode buildTree(int[] vals) {
    TreeNode[] nodes = Arrays.stream(vals).mapToObj(val -> val == -1 ? null : new TreeNode(val))
        .toArray(TreeNode[]::new);

    int n = vals.length;
    for (int i = 0; i < n; i++) {
      if (nodes[i] == null) {
        continue;
      }
      if (2 * i + 1 < n)
        nodes[i].left = nodes[2 * i + 1];
      if (2 * i + 2 < n)
        nodes[i].right = nodes[2 * i + 2];
    }
    return nodes[0];
  }

  private boolean isSameTree(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null) {
      return true;
    }
    if (node1 == null || node2 == null) {
      return false;
    }
    return node1.val == node2.val && isSameTree(node1.left, node2.left)
        && isSameTree(node1.right, node2.right);
  }
}
