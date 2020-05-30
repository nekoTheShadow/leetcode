package triples_with_bitwise_and_equal_to_zero;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test() {
        Solution solution = new Solution();
        assertEquals(12, solution.countTriplets(new int[] {2, 1, 3}));
    }

}
