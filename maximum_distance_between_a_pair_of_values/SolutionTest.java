package maximum_distance_between_a_pair_of_values;

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
        int[] nums1 = {55, 30, 5, 4, 2};
        int[] nums2 = {100, 20, 10, 10, 5};
        int output = 2;
        assertThat(solution.maxDistance(nums1, nums2)).isEqualTo(output);
    }

    @Test
    void example2() {
        int[] nums1 = {2, 2, 2};
        int[] nums2 = {10, 10, 1};
        int output = 1;
        assertThat(solution.maxDistance(nums1, nums2)).isEqualTo(output);
    }

    @Test
    void example3() {
        int[] nums1 = {30, 29, 19, 5};
        int[] nums2 = {25, 25, 25, 25, 25};
        int output = 2;
        assertThat(solution.maxDistance(nums1, nums2)).isEqualTo(output);
    }
}