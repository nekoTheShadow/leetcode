package minimum_moves_to_equal_array_elements_ii;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SolutionTest {
    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void example1() {
        int[] nums = new int[]{1, 2, 3};
        int output = 2;
        assertThat(solution.minMoves2(nums)).isEqualTo(output);
    }

    @Test
    void example2() {
        int[] nums = new int[]{1, 10, 2, 9};
        int output = 16;
        assertThat(solution.minMoves2(nums)).isEqualTo(output);
    }
}