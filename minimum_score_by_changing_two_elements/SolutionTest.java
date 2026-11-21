package minimum_score_by_changing_two_elements;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void example1() {
        int[] nums = new int[]{1, 4, 7, 8, 5};
        assertThat(new Solution().minimizeSum(nums)).isEqualTo(3);
    }

    @Test
    void example2() {
        int[] nums = new int[]{1, 4, 3};
        assertThat(new Solution().minimizeSum(nums)).isEqualTo(0);
    }
}