package sum_of_sortable_integers;

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
        int[] nums = {3, 1, 2};
        int output = 3;
        assertThat(solution.sortableIntegers(nums)).isEqualTo(output);
    }

    @Test
    void example2() {
        int[] nums = {7, 6, 5};
        int output = 0;
        assertThat(solution.sortableIntegers(nums)).isEqualTo(output);
    }

    @Test
    void example3() {
        int[] nums = {5, 8};
        int output = 3;
        assertThat(solution.sortableIntegers(nums)).isEqualTo(output);
    }
}