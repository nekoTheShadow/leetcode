package find_two_non_overlapping_sub_arrays_each_with_target_sum;

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
        int[] arr = {3, 2, 2, 4, 3};
        int target = 3;
        int output = 2;
        assertThat(solution.minSumOfLengths(arr, target)).isEqualTo(output);
    }


    @Test
    void example2() {
        int[] arr = {7, 3, 4, 7};
        int target = 7;
        int output = 2;
        assertThat(solution.minSumOfLengths(arr, target)).isEqualTo(output);
    }

    @Test
    void example3() {
        int[] arr = {4, 3, 2, 6, 2, 3, 4};
        int target = 6;
        int output = -1;
        assertThat(solution.minSumOfLengths(arr, target)).isEqualTo(output);
    }
}