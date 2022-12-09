package maximum_difference_between_node_and_ancestor;

import java.util.TreeMap;

public class Solution {
    public int maxAncestorDiff(TreeNode root) {
        ans = Integer.MIN_VALUE;
        t = new TreeMap<>();
        dfs(root);
        return ans;
    }

    private int ans;
    private TreeMap<Integer, Integer> t;

    public void dfs(TreeNode root) {
        if (root==null) {
            return ;
        }

        if (!t.isEmpty()) {
            ans = Math.max(ans, Math.abs(t.firstKey()-root.val));
            ans = Math.max(ans, Math.abs(t.lastKey()-root.val));
        }

        t.put(root.val, t.getOrDefault(root.val, 0)+1);
        dfs(root.left);
        dfs(root.right);

        if (t.get(root.val)==1) {
            t.remove(root.val);
        } else {
            t.put(root.val, t.get(root.val)-1);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
