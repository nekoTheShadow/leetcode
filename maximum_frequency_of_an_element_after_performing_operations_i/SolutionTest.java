package maximum_frequency_of_an_element_after_performing_operations_i;

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
        int[] nums = {1, 4, 5};
        int k = 1;
        int numOperations = 2;
        int output = 2;
        assertThat(solution.maxFrequency(nums, k, numOperations)).isEqualTo(output);
    }

    @Test
    void example2() {
        int[] nums = {5, 11, 20, 20};
        int k = 5;
        int numOperations = 1;
        int output = 2;
        assertThat(solution.maxFrequency(nums, k, numOperations)).isEqualTo(output);
    }
}