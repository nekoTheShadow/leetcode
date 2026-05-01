package check_if_there_is_a_valid_path_in_a_grid;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void example1() {
        String grid = "[[2,4,3],[6,5,2]]";
        assertThat(new Solution().hasValidPath(toGrid(grid))).isTrue();
    }

    @Test
    void example2() {
        String grid = "[[1,2,1],[1,2,1]]";
        assertThat(new Solution().hasValidPath(toGrid(grid))).isFalse();
    }


    @Test
    void example3() {
        String grid = "[[1,1,2]]";
        assertThat(new Solution().hasValidPath(toGrid(grid))).isFalse();
    }

    int[][] toGrid(String grid) {
        return Pattern.compile("\\[([-+,0-9]+)\\]")
                .matcher(grid)
                .results()
                .map(m -> Pattern.compile(",").splitAsStream(m.group(1))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);
    }
}