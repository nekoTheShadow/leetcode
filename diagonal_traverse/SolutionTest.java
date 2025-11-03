package diagonal_traverse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] expected = {1, 2, 4, 7, 5, 3, 6, 8, 9};
        int[] actual = solution.findDiagonalOrder(mat);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void example2() {
        int[][] mat = {{1, 2}, {3, 4}};
        int[] expected = {1, 2, 3, 4};
        int[] actual = solution.findDiagonalOrder(mat);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void example3() {
        int[][] mat = {{2, 3}};
        int[] expected = {2, 3};
        int[] actual = solution.findDiagonalOrder(mat);
        assertThat(actual).isEqualTo(expected);
    }
}
