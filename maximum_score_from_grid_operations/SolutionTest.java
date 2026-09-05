package maximum_score_from_grid_operations;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void example1() {
        String grid = "[[0,0,0,0,0],[0,0,3,0,0],[0,1,0,0,0],[5,0,0,3,0],[0,0,0,0,2]]";
        assertThat(new Solution().maximumScore(toGrid(grid))).isEqualTo(11);
    }

    @Test
    void example2() {
        String grid = "[[10,9,0,0,15],[7,1,0,8,0],[5,20,0,11,0],[0,0,0,1,2],[8,12,1,10,3]]";
        assertThat(new Solution().maximumScore(toGrid(grid))).isEqualTo(94);
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