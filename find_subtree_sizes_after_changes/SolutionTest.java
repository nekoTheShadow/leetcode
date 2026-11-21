package find_subtree_sizes_after_changes;

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
        int[] parent = new int[]{-1, 0, 0, 1, 1, 1};
        String s = "abaabc";
        assertThat(solution.findSubtreeSizes(parent, s)).isEqualTo(new int[]{6, 3, 1, 1, 1, 1});
    }


    @Test
    void example2() {
        int[] parent = new int[]{-1, 0, 4, 0, 1};
        String s = "abbba";
        assertThat(solution.findSubtreeSizes(parent, s)).isEqualTo(new int[]{5, 2, 1, 1, 1});
    }
}