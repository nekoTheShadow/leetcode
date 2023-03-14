package sum_root_to_leaf_numbers;

public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return solve(root, 0);
    }
    
    public int solve(TreeNode node, int sum) {
        if (node.left == null && node.right == null) {
            return sum*10 + node.val;
        }
        
        int ret = 0;
        if (node.left != null) {
            ret += solve(node.left, sum*10 + node.val);
        }
        if (node.right != null) {
            ret += solve(node.right, sum*10 + node.val);
        }
        return ret;
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
