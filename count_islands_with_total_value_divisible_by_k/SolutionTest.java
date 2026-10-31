package count_islands_with_total_value_divisible_by_k;

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
        String grid = "[[0,2,1,0,0],[0,5,0,0,5],[0,0,1,0,0],[0,1,4,7,0],[0,2,0,0,8]]";
        int k = 5;
        int output = 2;
        assertThat(solution.countIslands(toGrid(grid), k)).isEqualTo(output);
    }

    @Test
    void example2() {
        String grid = "[[3,0,3,0], [0,3,0,3], [3,0,3,0]]";
        int k = 3;
        int output = 6;
        assertThat(solution.countIslands(toGrid(grid), k)).isEqualTo(output);
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