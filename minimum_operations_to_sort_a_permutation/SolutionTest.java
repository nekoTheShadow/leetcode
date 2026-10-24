package minimum_operations_to_sort_a_permutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void example1() {
        assertEquals(2, new Solution().minOperations(new int[]{0, 2, 1}));
    }

    @Test
    void example2() {
        assertEquals(2, new Solution().minOperations(new int[]{1, 0, 2}));
    }

    @Test
    void example3() {
        assertEquals(-1, new Solution().minOperations(new int[]{2, 0, 1, 3}));
    }
}