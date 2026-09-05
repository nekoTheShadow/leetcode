package maximum_total_subarray_value_i;

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
        int[] nums = {1, 3, 2};
        int k = 2;
        int output = 4;
        assertThat(solution.maxTotalValue(nums, k)).isEqualTo(output);
    }

    @Test
    void example2() {
        int[] nums = {4, 2, 5, 1};
        int k = 3;
        int output = 12;
        assertThat(solution.maxTotalValue(nums, k)).isEqualTo(output);
    }
}