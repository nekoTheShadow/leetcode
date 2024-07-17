package delete_nodes_and_return_forest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        toDelete = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        nodes = new ArrayList<>();
        dfs(null, root);
        return nodes;
    }
    
    private Set<Integer> toDelete; 
    private List<TreeNode> nodes;
    
    public void dfs(TreeNode pre, TreeNode cur) {
    	if (cur == null) {
    		return ;
    	}
    	
    	if (toDelete.contains(cur.val)) {
    		if (pre != null) {
    			if (pre.left == cur) {
    				pre.left = null;
    			} else {
    				pre.right = null;
    			}
    		}
    		dfs(null, cur.left);
    		dfs(null, cur.right);
    	} else {
    		if (pre == null) {
    			nodes.add(cur);
    		}
    		dfs(cur, cur.left);
    		dfs(cur, cur.right);
    	}
    }
}