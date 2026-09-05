package smallest_missing_integer_greater_than_sequential_prefix_sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SolutionTest {
    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void example1() {
        assertThat(solution.missingInteger(new int[]{1, 2, 3, 2, 5})).isEqualTo(6);
    }

    @Test
    void example2() {
        assertThat(solution.missingInteger(new int[]{3, 4, 5, 1, 12, 14, 13})).isEqualTo(15);
    }
}