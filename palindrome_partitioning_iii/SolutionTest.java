package palindrome_partitioning_iii;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        assertEquals(1, solution.palindromePartition("abc", 2));
    }

    @Test
    void example2() {
        assertEquals(0, solution.palindromePartition("aabbc", 3));
    }

    @Test
    void example3() {
        assertEquals(0, solution.palindromePartition("leetcode", 8));
    }

    @Test
    void example4() {
        assertEquals(2, solution.palindromePartition("tcymekt", 4));
    }
}
