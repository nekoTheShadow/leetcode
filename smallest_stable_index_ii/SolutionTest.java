package smallest_stable_index_ii;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void example1() {
        assertEquals(3, solution.firstStableIndex(new int[]{5, 0, 1, 4}, 3));
    }

    @Test
    void example2() {
        assertEquals(-1, solution.firstStableIndex(new int[]{3, 2, 1}, 1));
    }

    @Test
    void example3() {
        assertEquals(0, solution.firstStableIndex(new int[]{0}, 0));
    }
}