package unique_3_digit_even_numbers;

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
        int[] digits = {1, 2, 3, 4};
        int output = 12;
        assertThat(solution.totalNumbers(digits)).isEqualTo(output);
    }

    @Test
    void example2() {
        int[] digits = {0, 2, 2};
        int output = 2;
        assertThat(solution.totalNumbers(digits)).isEqualTo(output);
    }

    @Test
    void example3() {
        int[] digits = {6, 6, 6};
        int output = 1;
        assertThat(solution.totalNumbers(digits)).isEqualTo(output);
    }

    @Test
    void example4() {
        int[] digits = {1, 3, 5};
        int output = 0;
        assertThat(solution.totalNumbers(digits)).isEqualTo(output);
    }
}