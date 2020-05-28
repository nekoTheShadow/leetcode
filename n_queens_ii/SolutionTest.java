package n_queens_ii;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        assertEquals(2, new Solution().totalNQueens(4));
    }
}
