package find_x_sum_of_all_k_long_subarrays_ii;

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
        int[] nums = {1, 1, 2, 2, 3, 4, 2, 3};
        int k = 6;
        int x = 2;
        long[] output = {6, 10, 12};
        assertThat(solution.findXSum(nums, k, x)).isEqualTo(output);
    }

    @Test
    void example2() {
        int[] nums = {3, 8, 7, 8, 7, 5};
        int k = 2;
        int x = 2;
        long[] output = {11, 15, 15, 15, 12};
        assertThat(solution.findXSum(nums, k, x)).isEqualTo(output);
    }
}