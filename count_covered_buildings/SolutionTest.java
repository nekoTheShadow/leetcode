package count_covered_buildings;


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
        int n = 3;
        String buildings = "[[1,2],[2,2],[3,2],[2,1],[2,3]]";
        int output = 1;
        assertThat(solution.countCoveredBuildings(n, matrix(buildings))).isEqualTo(output);
    }

    @Test
    void example2() {
        int n = 3;
        String buildings = "[[1,1],[1,2],[2,1],[2,2]]";
        int output = 0;
        assertThat(solution.countCoveredBuildings(n, matrix(buildings))).isEqualTo(output);
    }


    @Test
    void example3() {
        int n = 5;
        String buildings = "[[1,3],[3,2],[3,3],[3,5],[5,3]]";
        int output = 1;
        assertThat(solution.countCoveredBuildings(n, matrix(buildings))).isEqualTo(output);
    }

    int[][] matrix(String line) {
        return Pattern.compile("\\[([0-9]+),([0-9]+)\\]")
                .matcher(line)
                .results()
                .map(m -> new int[]{Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2))})
                .toArray(int[][]::new);
    }
}