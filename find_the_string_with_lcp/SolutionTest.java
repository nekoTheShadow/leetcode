package find_the_string_with_lcp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void example1() {
        String lcp = "[[4,0,2,0],[0,3,0,1],[2,0,2,0],[0,1,0,1]]";
        String output = "abab";
        assertThat(solution.findTheString(toMatrix(lcp))).isEqualTo(output);
    }

    @Test
    void example2() {
        String lcp = "[[4,3,2,1],[3,3,2,1],[2,2,2,1],[1,1,1,1]]";
        String output = "aaaa";
        assertThat(solution.findTheString(toMatrix(lcp))).isEqualTo(output);
    }

    @Test
    void example3() {
        String lcp = "[[4,3,2,1],[3,3,2,1],[2,2,2,1],[1,1,1,3]]";
        String output = "";
        assertThat(solution.findTheString(toMatrix(lcp))).isEqualTo(output);
    }

    int[][] toMatrix(String lcp) {
        return Pattern.compile("\\[([0-9,]+)\\]")
                .matcher(lcp)
                .results()
                .map(m -> Pattern.compile(",").splitAsStream(m.group(1)).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
    }
}