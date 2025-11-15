package count_the_number_of_substrings_with_dominant_ones;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void example() {
        Solution solution = new Solution();
        assertThat(solution.numberOfSubstrings("00011")).isEqualTo(5);
        assertThat(solution.numberOfSubstrings("101101")).isEqualTo(16);
    }
}