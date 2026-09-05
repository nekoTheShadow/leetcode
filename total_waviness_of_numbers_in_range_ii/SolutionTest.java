package total_waviness_of_numbers_in_range_ii;

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
        assertThat(solution.totalWaviness(120, 130)).isEqualTo(3);
    }

    @Test
    void example2() {
        assertThat(solution.totalWaviness(198, 202)).isEqualTo(3);
    }

    @Test
    void example3() {
        assertThat(solution.totalWaviness(4848, 4848)).isEqualTo(2);
    }
}