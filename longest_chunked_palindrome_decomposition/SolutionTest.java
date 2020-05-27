package longest_chunked_palindrome_decomposition;

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
        assertEquals(7, solution.longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"));
    }

    @Test
    void example2() {
        assertEquals(1, solution.longestDecomposition("merchant"));
    }

    @Test
    void example3() {
        assertEquals(11, solution.longestDecomposition("antaprezatepzapreanta"));
    }

    @Test
    void example4() {
        assertEquals(3, solution.longestDecomposition("aaa"));
    }

    @Test
    void example5() {
        assertEquals(2, solution.longestDecomposition("elvtoelvto"));
    }
}
