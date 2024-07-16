package step_by_step_directions_from_a_binary_tree_node_to_another;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		System.out.println(new Solution().getDirections(buildTree(List.of(5, 1, 2, 3, -1, 6, 4)), 3, 6));
		System.out.println(new Solution().getDirections(buildTree(List.of(2, 1, -1)), 2, 1));
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
	
	public static String toPrettyString(TreeNode root) {
    	List<TreeNode> nodes = new ArrayList<>();
    	nodes.add(root);
    	StringBuilder sb = new StringBuilder();
    	while (!nodes.stream().allMatch(node -> Objects.isNull(node))) {
    		sb.append(nodes.stream().map(node -> node == null ? "xxx" : String.valueOf(node.val)).collect(Collectors.joining(" ")));
    		sb.append(System.lineSeparator());
    		nodes = nodes.stream().flatMap(node -> node == null ? Stream.of(null, null) : Stream.of(node.left, node.right)).toList();
    	}
    	return sb.toString();
	}
}
