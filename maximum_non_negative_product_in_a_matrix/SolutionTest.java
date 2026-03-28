package maximum_non_negative_product_in_a_matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
        String grid = "[[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]";
        assertThat(solution.maxProductPath(toGrid(grid))).isEqualTo(-1);
    }

    @Test
    void example2() {
        String grid = "[[1,-2,1],[1,-2,1],[3,-4,1]]";
        assertThat(solution.maxProductPath(toGrid(grid))).isEqualTo(8);
    }


    @Test
    void example3() {
        String grid = "[[1,3],[0,-4]]";
        assertThat(solution.maxProductPath(toGrid(grid))).isEqualTo(0);
    }

    int[][] toGrid(String grid) {
        return Pattern.compile("\\[([-+,0-9]+)\\]")
                .matcher(grid)
                .results()
                .map(m -> Arrays.stream(m.group(1).split(",")).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
    }
}