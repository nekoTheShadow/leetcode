package longest_substring_of_one_repeating_character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        assertThat(solution.longestRepeating(
                "babacc",
                "bcb",
                new int[]{1, 3, 3}
        )).containsExactly(3, 3, 4);
    }

    @Test
    void example2() {
        assertThat(solution.longestRepeating(
                "abyzz",
                "aa",
                new int[]{2, 1}
        )).containsExactly(2, 3);
    }
}