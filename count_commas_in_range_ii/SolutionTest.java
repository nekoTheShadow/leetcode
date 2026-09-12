package count_commas_in_range_ii;


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
        assertThat(solution.countCommas(1002)).isEqualTo(3);
    }

    @Test
    void example2() {
        assertThat(solution.countCommas(998)).isEqualTo(0);
    }
}