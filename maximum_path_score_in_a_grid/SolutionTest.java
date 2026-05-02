package maximum_path_score_in_a_grid;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void example1() {
        String grid = "[[0,1],[2,0]]";
        int k = 1;
        int output = 2;
        assertThat(new Solution().maxPathScore(toGrid(grid), k)).isEqualTo(output);
    }

    @Test
    void example2() {
        String grid = "[[0,1],[1,2]]";
        int k = 1;
        int output = -1;
        assertThat(new Solution().maxPathScore(toGrid(grid), k)).isEqualTo(output);
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