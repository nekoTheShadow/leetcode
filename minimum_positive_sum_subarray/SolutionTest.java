package minimum_positive_sum_subarray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void example1() {
        List<Integer> nums = List.of(3, -2, 1, 4);
        int l = 2;
        int r = 3;
        int output = 1;
        assertThat(solution.minimumSumSubarray(nums, l, r)).isEqualTo(output);
    }

    @Test
    void example2() {
        List<Integer> nums = List.of(-2, 2, -3, 1);
        int l = 2;
        int r = 3;
        int output = -1;
        assertThat(solution.minimumSumSubarray(nums, l, r)).isEqualTo(output);
    }

    @Test
    void example3() {
        List<Integer> nums = List.of(1, 2, 3, 4);
        int l = 2;
        int r = 4;
        int output = 3;
        assertThat(solution.minimumSumSubarray(nums, l, r)).isEqualTo(output);
    }

    @Test
    void ng1() {
        List<Integer> nums = List.of(-3, 17);
        int l = 1;
        int r = 2;
        int output = 14;
        assertThat(solution.minimumSumSubarray(nums, l, r)).isEqualTo(output);
    }

    @Test
    void ng2() {
        List<Integer> nums = List.of(5, 8, -6);
        int l = 1;
        int r = 3;
        int output = 2;
        assertThat(solution.minimumSumSubarray(nums, l, r)).isEqualTo(output);
    }
}