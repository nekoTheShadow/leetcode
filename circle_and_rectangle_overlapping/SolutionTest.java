package circle_and_rectangle_overlapping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void example1() {
        assertThat(solution.checkOverlap(1, 0, 0, 1, -1, 3, 1)).isTrue();
    }


    @Test
    void example2() {
        assertThat(solution.checkOverlap(1, 1, 1, 1, -3, 2, -1)).isFalse();
    }


    @Test
    void example3() {
        assertThat(solution.checkOverlap(1, 0, 0, -1, 0, 0, 1)).isTrue();
    }
}