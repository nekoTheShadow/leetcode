package next_greater_numerically_balanced_number;

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
        assertThat(solution.nextBeautifulNumber(1)).isEqualTo(22);
    }

    @Test
    void example2() {
        assertThat(solution.nextBeautifulNumber(1000)).isEqualTo(1333);
    }

    @Test
    void example3() {
        assertThat(solution.nextBeautifulNumber(3000)).isEqualTo(3133);
    }
}