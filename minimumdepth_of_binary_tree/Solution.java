package minimumdepth_of_binary_tree;


public class Solution {
    public int minDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        if (root.left==null && root.right==null) {
            return 1;
        }
        
        int ret = Integer.MAX_VALUE;
        if (root.left!=null) {
            ret = Math.min(ret, minDepth(root.left)+1);
        }
        if (root.right!=null) {
            ret = Math.min(ret, minDepth(root.right)+1);
        }
        return ret;
    }
}
