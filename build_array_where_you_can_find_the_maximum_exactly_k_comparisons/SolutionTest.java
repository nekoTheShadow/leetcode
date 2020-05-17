package build_array_where_you_can_find_the_maximum_exactly_k_comparisons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SolutionTest {
    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void example1() {
        String[] words = new String[]{"dog","cat","dad","good"};
        char[] letters = new char[]{'a','a','c','d','d','d','g','o','o'};
        int[] score = new int[]{1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        assertEquals(23, solution.maxScoreWords(words, letters, score));
    }

    @Test
    public void example2() {
        String[] words = new String[]{"xxxz","ax","bx","cx"};
        char[] letters = new char[]{'z','a','b','c','x','x','x'};
        int[] score = new int[]{4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10};
        assertEquals(27, solution.maxScoreWords(words, letters, score));
    }

    @Test
    public void example3() {
        String[] words = new String[]{"leetcode"};
        char[] letters = new char[]{'l','e','t','c','o','d'};
        int[] score = new int[]{0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0};
        assertEquals(0, solution.maxScoreWords(words, letters, score));
    }

}
