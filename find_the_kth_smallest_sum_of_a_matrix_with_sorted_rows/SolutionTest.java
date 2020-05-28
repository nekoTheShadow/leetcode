package find_the_kth_smallest_sum_of_a_matrix_with_sorted_rows;

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
        int[][] mat = new int[][] {{1,3,11},{2,4,6}};
        int k = 5;
        assertEquals(7, solution.kthSmallest(mat, k));
    }

    @Test
    void example2() {
        int[][] mat = new int[][] {{1,3,11},{2,4,6}};
        int k = 9;
        assertEquals(17, solution.kthSmallest(mat, k));
    }


    @Test
    void example3() {
        int[][] mat = new int[][] {{1,10,10},{1,4,5},{2,3,6}};
        int k = 7;
        assertEquals(9, solution.kthSmallest(mat, k));
    }


    @Test
    void example4() {
        int[][] mat = new int[][] {{1,1,10},{2,2,9}};
        int k = 7;
        assertEquals(12, solution.kthSmallest(mat, k));
    }


}
