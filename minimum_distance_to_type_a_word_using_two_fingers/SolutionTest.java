package minimum_distance_to_type_a_word_using_two_fingers;

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
    void exapmle1() {
        assertEquals(3, solution.minimumDistance("CAKE"));
    }

    @Test
    void exapmle2() {
        assertEquals(6, solution.minimumDistance("HAPPY"));
    }

    @Test
    void exapmle3() {
        assertEquals(3, solution.minimumDistance("NEW"));
    }

    @Test
    void exapmle4() {
        assertEquals(7, solution.minimumDistance("YEAR"));
    }

}
