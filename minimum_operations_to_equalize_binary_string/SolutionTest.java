package minimum_operations_to_equalize_binary_string;

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
        String s = "110";
        int k = 1;
        int output = 1;
        assertThat(solution.minOperations(s, k)).isEqualTo(output);
    }

    @Test
    void example2() {
        String s = "0101";
        int k = 3;
        int output = 2;
        assertThat(solution.minOperations(s, k)).isEqualTo(output);
    }

    @Test
    void example3() {
        String s = "101";
        int k = 2;
        int output = -1;
        assertThat(solution.minOperations(s, k)).isEqualTo(output);
    }
}