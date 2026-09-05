package maximize_the_distance_between_points_on_a_square;

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
        int side = 2;
        int[][] points = toGrid("[[0,2],[2,0],[2,2],[0,0]]");
        int k = 4;
        int output = 2;
        assertThat(solution.maxDistance(side, points, k)).isEqualTo(output);
    }

    @Test
    void example2() {
        int side = 2;
        int[][] points = toGrid("[[0,0],[1,2],[2,0],[2,2],[2,1]]");
        int k = 4;
        int output = 1;
        assertThat(solution.maxDistance(side, points, k)).isEqualTo(output);
    }


    @Test
    void example3() {
        int side = 2;
        int[][] points = toGrid("[[0,0],[0,1],[0,2],[1,2],[2,0],[2,2],[2,1]]");
        int k = 5;
        int output = 1;
        assertThat(solution.maxDistance(side, points, k)).isEqualTo(output);
    }


    @Test
    void ng1() {
        int side = 6;
        int[][] points = toGrid("[[2,0],[5,0],[0,0],[2,6]]");
        int k = 4;
        int output = 2;
        assertThat(solution.maxDistance(side, points, k)).isEqualTo(output);
    }


    private int[][] toGrid(String grid) {
        return Pattern.compile("\\[([-+,0-9]+)\\]")
                .matcher(grid)
                .results()
                .map(m -> Pattern.compile(",").splitAsStream(m.group(1))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);
    }
}