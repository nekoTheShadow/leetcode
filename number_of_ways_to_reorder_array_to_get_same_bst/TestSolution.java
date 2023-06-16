package number_of_ways_to_reorder_array_to_get_same_bst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSolution {
    @Test
    void example1() {
        assertEquals(1, new Solution().numOfWays(new int[] {2,1,3}));
    }
    
    @Test
    void example2() {
        assertEquals(5, new Solution().numOfWays(new int[] {3,4,5,1,2}));
    }
    
    @Test
    void example3() {
        assertEquals(0, new Solution().numOfWays(new int[] {1,2,3}));
    }

}
