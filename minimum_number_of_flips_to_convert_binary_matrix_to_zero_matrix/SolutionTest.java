package minimum_number_of_flips_to_convert_binary_matrix_to_zero_matrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() throws Exception {
        this.solution = new Solution();
    }

    @Test
    void example1() {
        assertEquals(3, solution.minFlips(new int[][]{{0,0},{0,1}}));
    }

    @Test
    void example2() {
        assertEquals(0, solution.minFlips(new int[][]{{0}}));
    }

    @Test
    void example3() {
        assertEquals(6, solution.minFlips(new int[][]{{1,1,1},{1,0,1},{0,0,0}}));
    }

    @Test
    void example4() {
        assertEquals(-1, solution.minFlips(new int[][]{{1,0,0},{1,0,0}}));
    }

}
