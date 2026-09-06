package construct_uniform_parity_array_ii;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        assertThat(solution.uniformArray(new int[]{1, 4, 7})).isTrue();
    }

    @Test
    void example2() {
        assertThat(solution.uniformArray(new int[]{2, 3})).isFalse();
    }

    @Test
    void example3() {
        assertThat(solution.uniformArray(new int[]{4, 6})).isTrue();
    }
}