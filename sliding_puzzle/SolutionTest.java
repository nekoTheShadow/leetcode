package sliding_puzzle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = new Solution();
    }

    @Test
    void example1() {
        int[][] board = new int[][] {{1, 2, 3}, {4, 0, 5}};
        assertEquals(1, solution.slidingPuzzle(board));
    }

    @Test
    void example2() {
        int[][] board = new int[][] {{1, 2, 3}, {5, 4, 0}};
        assertEquals(-1, solution.slidingPuzzle(board));
    }

    @Test
    void example3() {
        int[][] board = new int[][] {{4, 1, 2}, {5, 0, 3}};
        assertEquals(5, solution.slidingPuzzle(board));
    }

    @Test
    void example4() {
        int[][] board = new int[][] {{3, 2, 4}, {1, 5, 0}};
        assertEquals(14, solution.slidingPuzzle(board));
    }
}
