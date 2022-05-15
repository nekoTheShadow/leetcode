package deepest_leaves_sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int deepestLeavesSum(TreeNode root) {
        List<TreeNode> a = new ArrayList<>();
        a.add(root);
        while (true) {
            List<TreeNode> b = new ArrayList<>();
            for (TreeNode cur : a) {
                if (cur.left != null) b.add(cur.left);
                if (cur.right != null) b.add(cur.right);
            }
            
            if (b.isEmpty()) break;
            a = b;
        }
        return a.stream().mapToInt(t -> t.val).sum();
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
