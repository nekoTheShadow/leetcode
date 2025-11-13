package maximum_number_of_operations_to_move_ones_to_the_end;

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
        assertThat(solution.maxOperations("1001101")).isEqualTo(4);
    }

    @Test
    void example2() {
        assertThat(solution.maxOperations("00111")).isEqualTo(0);
    }
}