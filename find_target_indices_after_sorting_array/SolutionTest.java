package find_target_indices_after_sorting_array;

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
        int[] nums = new int[]{1, 2, 5, 2, 3};
        int target = 2;
        List<Integer> output = List.of(1, 2);
        assertThat(solution.targetIndices(nums, target)).isEqualTo(output);
    }

    @Test
    void example2() {
        int[] nums = new int[]{1, 2, 5, 2, 3};
        int target = 3;
        List<Integer> output = List.of(3);
        assertThat(solution.targetIndices(nums, target)).isEqualTo(output);
    }

    @Test
    void example3() {
        int[] nums = new int[]{1, 2, 5, 2, 3};
        int target = 5;
        List<Integer> output = List.of(4);
        assertThat(solution.targetIndices(nums, target)).isEqualTo(output);
    }
}