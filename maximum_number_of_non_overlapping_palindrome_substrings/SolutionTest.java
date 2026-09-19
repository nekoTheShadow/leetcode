package maximum_number_of_non_overlapping_palindrome_substrings;

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
        assertThat(solution.maxPalindromes("abaccdbbd", 3)).isEqualTo(2);
    }


    @Test
    void example2() {
        assertThat(solution.maxPalindromes("adbcda", 2)).isEqualTo(0);
    }
}