package minimum_falling_path_sum_ii;

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
    void test() {
        assertEquals(13, solution.minFallingPathSum(new int[][] {{1,2,3},{4,5,6},{7,8,9}}));
    }

}
