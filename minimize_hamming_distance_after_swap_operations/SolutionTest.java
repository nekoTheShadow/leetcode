package minimize_hamming_distance_after_swap_operations;

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
        int[] source = {1, 2, 3, 4};
        int[] target = {2, 1, 4, 5};
        int[][] allowedSwaps = toGrid("[[0,1],[2,3]]");
        int output = 1;
        assertThat(solution.minimumHammingDistance(source, target, allowedSwaps)).isEqualTo(output);
    }

    @Test
    void example2() {
        int[] source = {1, 2, 3, 4};
        int[] target = {1, 3, 2, 4};
        int[][] allowedSwaps = toGrid("[]");
        int output = 2;
        assertThat(solution.minimumHammingDistance(source, target, allowedSwaps)).isEqualTo(output);
    }

    @Test
    void example3() {
        int[] source = {5, 1, 2, 4, 3};
        int[] target = {1, 5, 4, 2, 3};
        int[][] allowedSwaps = toGrid("[[0,4],[4,2],[1,3],[1,4]]");
        int output = 0;
        assertThat(solution.minimumHammingDistance(source, target, allowedSwaps)).isEqualTo(output);
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