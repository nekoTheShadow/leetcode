package find_x_value_of_array_i;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void example1() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int k = 3;
        long[] output = new long[]{9, 2, 4};
        assertThat(new Solution().resultArray(nums, k)).isEqualTo(output);
    }

    @Test
    void example2() {
        int[] nums = new int[]{1, 2, 4, 8, 16, 32};
        int k = 4;
        long[] output = new long[]{18, 1, 2, 0};
        assertThat(new Solution().resultArray(nums, k)).isEqualTo(output);
    }

    @Test
    void example3() {
        int[] nums = new int[]{1, 1, 2, 1, 1};
        int k = 2;
        long[] output = new long[]{9, 6};
        assertThat(new Solution().resultArray(nums, k)).isEqualTo(output);
    }
}