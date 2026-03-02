package minimum_swaps_to_arrange_a_binary_grid;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void example1() {
        String grid = "[[0,0,1],[1,1,0],[1,0,0]]";
        int output = 3;
        assertThat(new Solution().minSwaps(toGrid(grid))).isEqualTo(output);
    }

    @Test
    void example2() {
        String grid = "[[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]";
        int output = -1;
        assertThat(new Solution().minSwaps(toGrid(grid))).isEqualTo(output);
    }

    @Test
    void example3() {
        String grid = "[[1,0,0],[1,1,0],[1,1,1]]";
        int output = 0;
        assertThat(new Solution().minSwaps(toGrid(grid))).isEqualTo(output);
    }


    int[][] toGrid(String grid) {
        return Pattern.compile("\\[([01,]+)\\]")
                .matcher(grid)
                .results()
                .map(m -> Arrays.stream(m.group(1).split(",")).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
    }
}