package xor_after_range_multiplication_queries_ii;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void example1() {
        Solution sol = new Solution();

        int[] nums = {1, 1, 1};
        int[][] queries = {
                {0, 2, 1, 4}
        };

        int result = sol.xorAfterQueries(nums, queries);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void example2() {
        Solution sol = new Solution();

        int[] nums = {2, 3, 1, 5, 4};
        int[][] queries = {
                {1, 4, 2, 3},
                {0, 2, 1, 2}
        };

        int result = sol.xorAfterQueries(nums, queries);

        assertThat(result).isEqualTo(31);
    }
}