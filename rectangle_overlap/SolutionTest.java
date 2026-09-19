package rectangle_overlap;

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
        assertThat(solution.isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3})).isTrue();
    }

    @Test
    void example2() {
        assertThat(solution.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1})).isFalse();
    }

    @Test
    void example3() {
        assertThat(solution.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{2, 2, 3, 3})).isFalse();
    }
}