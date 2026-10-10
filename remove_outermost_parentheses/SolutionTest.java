package remove_outermost_parentheses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void example1() {
        assertThat(solution.removeOuterParentheses("(()())(())")).isEqualTo("()()()");
    }


    @Test
    void example2() {
        assertThat(solution.removeOuterParentheses("(()())(())(()(()))")).isEqualTo("()()()()(())");
    }

    @Test
    void example3() {
        assertThat(solution.removeOuterParentheses("()()")).isEqualTo("");
    }
}
