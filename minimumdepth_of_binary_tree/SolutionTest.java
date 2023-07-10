package minimumdepth_of_binary_tree;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {
    
    Solution solution;
    
    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void example1() {
        TreeNode root = TreeNode.makeTree(new Integer[] {3,9,20,null,null,15,7});
        assertEquals(2	, solution.minDepth(root));
    }

    @Test
    void example2() {
        TreeNode[] nodes = IntStream.of(2, 3, 4, 5, 6).mapToObj(v -> new TreeNode(v)).toArray(TreeNode[]::new);
        for (int i = 0; i < nodes.length-1; i++) {
            nodes[i].right = nodes[i+1];
        }
        assertEquals(5	, solution.minDepth(nodes[0]));
    }
}
