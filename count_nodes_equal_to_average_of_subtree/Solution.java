package count_nodes_equal_to_average_of_subtree;


public class Solution {
    public int averageOfSubtree(TreeNode root) {
        Tuple tuple = dfs(root);
        return tuple.answer();
    }

    private Tuple dfs(TreeNode node) {
        int total = node.val;
        int count = 1;
        int answer = 0;
        if (node.left != null) {
            Tuple tuple = dfs(node.left);
            total += tuple.total();
            count += tuple.count();
            answer += tuple.answer();
        }
        if (node.right != null) {
            Tuple tuple = dfs(node.right);
            total += tuple.total();
            count += tuple.count();
            answer += tuple.answer();
        }
        if (total / count == node.val) {
            answer++;
        }
        return new Tuple(total, count, answer);
    }
}

record Tuple(int total, int count, int answer) {

}
