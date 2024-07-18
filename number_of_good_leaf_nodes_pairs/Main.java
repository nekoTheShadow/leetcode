package number_of_good_leaf_nodes_pairs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		System.out.println(new Solution().countPairs(buildTree(List.of(1,2,3,-1,4)), 3));
		System.out.println(new Solution().countPairs(buildTree(List.of(1,2,3,4,5,6,7)), 3));
	}
	
	
	public static TreeNode buildTree(List<Integer> vals) {
		List<TreeNode> nodes  = vals.stream().map(val -> val == -1 ? null : new TreeNode(val)).toList();
		for (int i = 0, n = vals.size(); i < n; i++) {
			if (nodes.get(i) == null) {
				continue;
			}
			
			if (2*i+1<n) {
				nodes.get(i).left = nodes.get(2*i+1);
			}
			if (2*i+2<n) {
				nodes.get(i).right = nodes.get(2*i+2);
			}
		}
		return nodes.get(0);
	}
	
	public static void prettyPrint(List<TreeNode> nodes) {
		System.out.println(nodes.stream().map(node -> prettyString(node)).collect(Collectors.joining(" ")));
	}
	
	public static String prettyString(TreeNode root) {
    	List<TreeNode> nodes = new ArrayList<>();
    	nodes.add(root);
    	List<String> vals = new ArrayList<>();
    	while (!nodes.stream().allMatch(Objects::isNull)) {
    		nodes.stream().map(node -> node == null ? "x" : String.valueOf(node.val)).forEach(vals::add);
    		nodes = nodes.stream().flatMap(node -> node == null ? Stream.of(null, null) : Stream.of(node.left, node.right)).toList();
    	}
    	return vals.stream().collect(Collectors.joining(",", "[", "]"));
	}
}
