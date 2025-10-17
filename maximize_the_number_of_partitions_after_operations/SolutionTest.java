package maximize_the_number_of_partitions_after_operations;

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
        String s = "accca";
        int k = 2;
        int output = 3;
        assertThat(solution.maxPartitionsAfterOperations(s, k)).isEqualTo(output);
    }

    @Test
    void example2() {
        String s = "aabaab";
        int k = 3;
        int output = 1;
        assertThat(solution.maxPartitionsAfterOperations(s, k)).isEqualTo(output);
    }

    @Test
    void example3() {
        String s = "xxyz";
        int k = 1;
        int output = 4;
        assertThat(solution.maxPartitionsAfterOperations(s, k)).isEqualTo(output);
    }
}