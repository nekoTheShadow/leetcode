package minimize_the_maximum_difference_of_pairs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {
    Solution s;
    
    
    @BeforeEach
    void setup() {
        s = new Solution();
    }

    @Test
    void example1() {
        int[] nums = new int[] {10,1,2,7,1,3};
        int p = 2;
        int expected = 1;
        assertEquals(expected, s.minimizeMax(nums, p));
    }

    @Test
    void example2() {
        int[] nums = new int[] {4,2,1,2};
        int p = 1;
        int expected = 0;
        assertEquals(expected, s.minimizeMax(nums, p));
    }
}
