package remove_invalid_parentheses;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void example1() {
        String s = "()())()";
        List<String> output = List.of("(())()", "()()()");
        assertThat(new Solution().removeInvalidParentheses(s)).containsExactlyInAnyOrderElementsOf(output);
    }

    @Test
    void example2() {
        String s = "(a)())()";
        List<String> output = List.of("(a())()", "(a)()()");
        assertThat(new Solution().removeInvalidParentheses(s)).containsExactlyInAnyOrderElementsOf(output);
    }

    @Test
    void example3() {
        String s = ")(";
        List<String> output = List.of("");
        assertThat(new Solution().removeInvalidParentheses(s)).containsExactlyInAnyOrderElementsOf(output);
    }
}