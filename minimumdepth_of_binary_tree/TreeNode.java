package minimumdepth_of_binary_tree;

import java.util.Arrays;

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
     public static TreeNode makeTree(Integer[] vals) {
         int n = vals.length;
         TreeNode[] nodes = Arrays.stream(vals).map(val -> val==null ? null : new TreeNode(val)).toArray(TreeNode[]::new);
         for (int i = 0; i < n; i++) {
             if (nodes[i] == null) {
                 continue;
             }
             
             if (i*2+1<n) {
                 nodes[i].left = nodes[i*2+1];
             }
             if (i*2+2<n) {
                 nodes[i].right = nodes[i*2+2];
             }
         }
         return nodes[0];
      }
}
