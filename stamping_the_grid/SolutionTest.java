package stamping_the_grid;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {
    Solution solution;
    
    @BeforeEach
    void setup() {
        solution = new Solution();
    }
    
    @Test
    void example1() {
        int[][] grid = new int[][]{{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0}};
        assertTrue(solution.possibleToStamp(grid, 4, 3));
    }

    @Test
    void example2() {
        int[][] grid = new int[][]{{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
        assertFalse(solution.possibleToStamp(grid, 2, 2));
    }
}
