package step_by_step_directions_from_a_binary_tree_node_to_another;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;



public class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        Map<Integer, List<GraphNode>> g = buildGraph(root);
        
        Queue<Integer> q = new ArrayDeque<>();
        Map<Integer, Integer> d = new HashMap<>();
        Map<Integer, GraphNode> p = new HashMap<>();
        
        q.add(startValue);
        d.put(startValue, 0);
        while (!q.isEmpty()) {
        	Integer cur = q.poll();
        	if (!g.containsKey(cur)) {
        		continue;
        	}
        	
        	for (GraphNode nxt : g.get(cur)) {
        		if (!d.containsKey(nxt.val()) || d.get(cur)+1 < d.get(nxt.val())) {
        			d.put(nxt.val(), d.get(cur)+1);
        			p.put(nxt.val(), new GraphNode(cur, nxt.dest()));
        			q.add(nxt.val());
        		}
        	}
        }
        
        int cur = destValue;
        StringBuilder sb = new StringBuilder();
        while (cur != startValue) {
        	GraphNode nxt = p.get(cur);
        	sb.append(nxt.dest());
        	cur = nxt.val();
        }
        
        return sb.reverse().toString();
    }
    
    private Map<Integer, List<GraphNode>> buildGraph(TreeNode root) {
        Map<Integer, List<GraphNode>> g = new HashMap<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
        	TreeNode cur = q.remove();
        	if (cur.left != null) {
        		g.computeIfAbsent(cur.val, unused -> new ArrayList<GraphNode>()).add(new GraphNode(cur.left.val, "L"));
        		g.computeIfAbsent(cur.left.val, unused -> new ArrayList<GraphNode>()).add( new GraphNode(cur.val, "U"));
        		q.add(cur.left);
        	}
        	if (cur.right != null) {
        		g.computeIfAbsent(cur.val, unused -> new ArrayList<GraphNode>()).add(new GraphNode(cur.right.val, "R"));
        		g.computeIfAbsent(cur.right.val, unused -> new ArrayList<GraphNode>()).add( new GraphNode(cur.val, "U"));
        		q.add(cur.right);
        	}
        }
        return g;
    }
    
    
    record GraphNode(int val, String dest) {
    }
}
