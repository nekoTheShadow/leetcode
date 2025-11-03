package sort_matrix_by_diagonals;


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
        int[][] mat = {{1, 7, 3}, {9, 8, 2}, {4, 5, 6}};
        int[][] expected = {{8, 2, 3}, {9, 6, 7}, {4, 5, 1}};
        int[][] actual = solution.sortMatrix(mat);
        assertThat(actual).isDeepEqualTo(expected);
    }

    @Test
    void example2() {
        int[][] mat = {{0, 1}, {1, 2}};
        int[][] expected = {{2, 1}, {1, 0}};
        int[][] actual = solution.sortMatrix(mat);
        assertThat(actual).isDeepEqualTo(expected);
    }

    @Test
    void example3() {
        int[][] mat = {{1}};
        int[][] expected = {{1}};
        int[][] actual = solution.sortMatrix(mat);
        assertThat(actual).isDeepEqualTo(expected);
    }
}
