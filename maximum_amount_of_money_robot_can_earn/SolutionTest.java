package maximum_amount_of_money_robot_can_earn;

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
        int[][] grid = toGrid("[[0,1,-1],[1,-2,3],[2,-3,4]]");
        int output = 8;
        assertThat(solution.maximumAmount(grid)).isEqualTo(output);
    }


    @Test
    void example2() {
        int[][] grid = toGrid("[[10,10,10],[10,10,10]]");
        int output = 40;
        assertThat(solution.maximumAmount(grid)).isEqualTo(output);
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