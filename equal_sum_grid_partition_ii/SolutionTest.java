package equal_sum_grid_partition_ii;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void example1() {
        int[][] grid = toGrid("[[1,4],[2,3]]");
        assertThat(new Solution().canPartitionGrid(grid)).isTrue();
    }

    @Test
    void example2() {
        int[][] grid = toGrid("[[1,2],[3,4]]");
        assertThat(new Solution().canPartitionGrid(grid)).isTrue();
    }


    @Test
    void example3() {
        int[][] grid = toGrid("[[1,2,4],[2,3,5]]");
        assertThat(new Solution().canPartitionGrid(grid)).isFalse();
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