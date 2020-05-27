package parsing_a_boolean_expression;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = new Solution();
    }

    @Test
    void exapmle1() {
        assertTrue(solution.parseBoolExpr("!(f)"));
    }

    @Test
    void exapmle2() {
        assertTrue(solution.parseBoolExpr("|(f,t)"));
    }

    @Test
    void exapmle3() {
        assertFalse(solution.parseBoolExpr("&(t,f)"));
    }

    @Test
    void exapmle4() {
        assertFalse(solution.parseBoolExpr("|(&(t,f,t),!(t))"));
    }
}
