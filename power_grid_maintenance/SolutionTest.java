package power_grid_maintenance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void example1() {
        Solution solution = new Solution();
        int c = 5;
        int[][] connections = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5}
        };
        int[][] queries = {
                {1, 3},
                {2, 1},
                {1, 1},
                {2, 2},
                {1, 2}
        };

        int[] expected = {3, 2, 3};
        int[] actual = solution.processQueries(c, connections, queries);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        int c = 3;
        int[][] connections = {}; // 空の接続
        int[][] queries = {
                {1, 1},
                {2, 1},
                {1, 1}
        };

        int[] expected = {1, -1};
        int[] actual = solution.processQueries(c, connections, queries);

        assertThat(actual).isEqualTo(expected);
    }
}