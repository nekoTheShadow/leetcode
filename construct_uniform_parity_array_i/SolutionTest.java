package construct_uniform_parity_array_i;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    @Test
    void example1() {
        assertTrue(new Solution().uniformArray(new int[]{2, 3}));
    }

    @Test
    void example2() {
        assertTrue(new Solution().uniformArray(new int[]{4, 6}));
    }
}