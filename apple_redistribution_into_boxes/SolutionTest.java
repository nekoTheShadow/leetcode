package apple_redistribution_into_boxes;

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
        int[] apple = {1, 3, 2};
        int[] capacity = {4, 3, 1, 5, 2};
        int output = 2;
        assertThat(solution.minimumBoxes(apple, capacity)).isEqualTo(output);
    }

    @Test
    void example2() {
        int[] apple = {5, 5, 5};
        int[] capacity = {2, 4, 2, 7};
        int output = 4;
        assertThat(solution.minimumBoxes(apple, capacity)).isEqualTo(output);
    }
}