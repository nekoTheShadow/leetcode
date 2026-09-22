package find_x_value_of_array_ii;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        int[][] queries = toGrid("[[2,2,0,2],[3,3,3,0],[0,1,0,1]]");
        int[] output = {2, 2, 2};
        assertThat(new Solution().resultArray(nums, k, queries)).isEqualTo(output);
    }

    @Test
    void example2() {
        int[] nums = {1, 2, 4, 8, 16, 32};
        int k = 4;
        int[][] queries = toGrid("[[0,2,0,2],[0,2,0,1]]");
        int[] output = {1, 0};
        assertThat(new Solution().resultArray(nums, k, queries)).isEqualTo(output);
    }

    @Test
    void example3() {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 2;
        int[][] queries = toGrid("[[2,1,0,1]]");
        int[] output = {5};
        assertThat(new Solution().resultArray(nums, k, queries)).isEqualTo(output);
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