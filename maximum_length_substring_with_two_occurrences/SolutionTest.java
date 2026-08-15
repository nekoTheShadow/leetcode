package maximum_length_substring_with_two_occurrences;

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
        assertThat(solution.maximumLengthSubstring("bcbbbcba")).isEqualTo(4);
    }

    @Test
    void example2() {
        assertThat(solution.maximumLengthSubstring("aaaa")).isEqualTo(2);
    }

}