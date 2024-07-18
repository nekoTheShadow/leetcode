package number_of_good_leaf_nodes_pairs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int countPairs(TreeNode root, int distance) {
    	this.graph = new HashMap<>();
    	this.leafs = new HashSet<>();
    	this.distance = distance;
    	this.count = 0;
    	
    	buildGraphAndLeafs(root);
    	for (TreeNode leaf : leafs) {
    		countGoodLeafNodes(null, leaf, 0);
    	}
    	
    	return count/2;
    }
    
    private Map<TreeNode, List<TreeNode>> graph;
    private Set<TreeNode> leafs;
    private int distance;
    private int count;
    
    
    public void buildGraphAndLeafs(TreeNode root) {
    	if (root.left == null && root.right == null) {
    		leafs.add(root);
    	}
    	
    	if (root.left != null) {
    		graph.computeIfAbsent(root, unused -> new ArrayList<TreeNode>()).add(root.left);
    		graph.computeIfAbsent(root.left, unused -> new ArrayList<TreeNode>()).add(root);
    		buildGraphAndLeafs(root.left);
    	}
    	if (root.right != null) {
    		graph.computeIfAbsent(root, unused -> new ArrayList<TreeNode>()).add(root.right);
    		graph.computeIfAbsent(root.right, unused -> new ArrayList<TreeNode>()).add(root);
    		buildGraphAndLeafs(root.right);
    	}
    }
    
    
    public void countGoodLeafNodes(TreeNode pre, TreeNode cur, int d) {
    	if (leafs.contains(cur)) {
    		if (pre != null && d <= distance) {
    			count++;
    		}
    	} 
    	for (TreeNode nxt : graph.getOrDefault(cur, Collections.emptyList())) {
    		if (pre != nxt) {
    			countGoodLeafNodes(cur, nxt, d+1);
    		}
    	}
    }
}
