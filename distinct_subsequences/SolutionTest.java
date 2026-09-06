package distinct_subsequences;

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
        String s = "rabbbit";
        String t = "rabbit";
        int output = 3;
        assertThat(solution.numDistinct(s, t)).isEqualTo(output);
    }

    @Test
    void example2() {
        String s = "babgbag";
        String t = "bag";
        int output = 5;
        assertThat(solution.numDistinct(s, t)).isEqualTo(output);
    }
}