package final_value_of_variable_after_performing_operations;

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
        String[] operations = {"--X", "X++", "X++"};
        int output = 1;
        assertThat(solution.finalValueAfterOperations(operations)).isEqualTo(output);
    }

    @Test
    void example2() {
        String[] operations = {"++X", "++X", "X++"};
        int output = 3;
        assertThat(solution.finalValueAfterOperations(operations)).isEqualTo(output);
    }

    @Test
    void example3() {
        String[] operations = {"X++", "++X", "--X", "X--"};
        int output = 0;
        assertThat(solution.finalValueAfterOperations(operations)).isEqualTo(output);
    }
}