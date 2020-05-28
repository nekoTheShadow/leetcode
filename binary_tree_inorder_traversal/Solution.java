package binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> vals = new ArrayList<>();
        if (root.left != null) {
            vals.addAll(inorderTraversal(root.left));
        }
        vals.add(root.val);
        if (root.right != null) {
            vals.addAll(inorderTraversal(root.right));
        }
        return vals;
    }
}
