package lexicographically_smallest_string_after_applying_operations;

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
        String s = "5525";
        int a = 9;
        int b = 2;
        String output = "2050";
        assertThat(solution.findLexSmallestString(s, a, b)).isEqualTo(output);
    }

    @Test
    void example2() {
        String s = "74";
        int a = 5;
        int b = 1;
        String output = "24";
        assertThat(solution.findLexSmallestString(s, a, b)).isEqualTo(output);
    }

    @Test
    void example3() {
        String s = "0011";
        int a = 4;
        int b = 2;
        String output = "0011";
        assertThat(solution.findLexSmallestString(s, a, b)).isEqualTo(output);
    }
}