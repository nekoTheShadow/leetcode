package closest_equal_element_queries;

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
        int[] nums = {1, 3, 1, 4, 1, 3, 2};
        int[] queries = {0, 3, 5};
        List<Integer> output = List.of(2, -1, 3);
        assertThat(solution.solveQueries(nums, queries)).isEqualTo(output);
    }


    @Test
    void example2() {
        int[] nums = {1, 2, 3, 4};
        int[] queries = {0, 1, 2, 3};
        List<Integer> output = List.of(-1, -1, -1, -1);
        assertThat(solution.solveQueries(nums, queries)).isEqualTo(output);
    }
}