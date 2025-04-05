package lowest_common_ancestor_of_deepest_leaves;

public class Solution {
  public TreeNode lcaDeepestLeaves(TreeNode root) {
    return dfs(root, 0).node();
  }

  private Tuple dfs(TreeNode node, int depth) {
    if (node == null) {
      return new Tuple(null, depth);
    }

    Tuple l = dfs(node.left, depth + 1);
    Tuple r = dfs(node.right, depth + 1);

    if (l.depth() > r.depth()) {
      return new Tuple(l.node(), l.depth());
    } else if (l.depth() < r.depth()) {
      return new Tuple(r.node(), r.depth());
    } else {
      return new Tuple(node, l.depth());
    }
  }

  private static record Tuple(TreeNode node, int depth) {
  }
}
