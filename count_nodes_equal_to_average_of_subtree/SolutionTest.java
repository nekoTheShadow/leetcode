package count_nodes_equal_to_average_of_subtree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void example1() {
        int[] vals = {4, 8, 5, 0, 1, -1, 6};
        int output = 5;
        assertThat(solution.averageOfSubtree(build(vals, 0))).isEqualTo(output);
    }

    @Test
    void example2() {
        int[] vals = {1};
        int output = 1;
        assertThat(solution.averageOfSubtree(build(vals, 0))).isEqualTo(output);
    }

    TreeNode build(int[] vals, int index) {
        if (vals.length <= index || vals[index] == -1) {
            return null;
        }
        return new TreeNode(vals[index], build(vals, 2 * index + 1), build(vals, 2 * index + 2));
    }
}