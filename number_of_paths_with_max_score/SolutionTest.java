package number_of_paths_with_max_score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        List<String> board = Arrays.asList("E23", "2X2", "12S");
        int[] result = solution.pathsWithMaxScore(board);
        assertThat(result).containsExactly(7, 1);
    }

    @Test
    void example2() {
        List<String> board = Arrays.asList("E12", "1X1", "21S");
        int[] result = solution.pathsWithMaxScore(board);
        assertThat(result).containsExactly(4, 2);
    }

    @Test
    void example3() {
        List<String> board = Arrays.asList("E11", "XXX", "11S");
        int[] result = solution.pathsWithMaxScore(board);
        assertThat(result).containsExactly(0, 0);
    }
}