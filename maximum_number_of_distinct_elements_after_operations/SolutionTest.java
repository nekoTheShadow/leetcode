package maximum_number_of_distinct_elements_after_operations;

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
        int[] nums = {1, 2, 2, 3, 3, 4};
        int k = 2;
        int output = 6;
        assertThat(solution.maxDistinctElements(nums, k)).isEqualTo(output);
    }

    @Test
    void example2() {
        int[] nums = {4, 4, 4, 4};
        int k = 1;
        int output = 3;
        assertThat(solution.maxDistinctElements(nums, k)).isEqualTo(output);
    }
}