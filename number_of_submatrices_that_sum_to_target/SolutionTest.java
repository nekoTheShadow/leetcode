package number_of_submatrices_that_sum_to_target;

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
        int[][] matrix = new int[][] {{0,1,0},{1,1,1},{0,1,0}};
        assertEquals(4, solution.numSubmatrixSumTarget(matrix, 0));
    }

    @Test
    void example2() {
        int[][] matrix = new int[][] {{1,-1},{-1,1}};
        assertEquals(5, solution.numSubmatrixSumTarget(matrix, 0));
    }

}
