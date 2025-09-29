package minimum_score_triangulation_of_polygon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    Solution s;

    @BeforeEach
    void setup() {
        s = new Solution();
    }

    @Test
    void example1() {
        int[] values = {1, 2, 3};
        int output = 6;
        assertThat(s.minScoreTriangulation(values)).isEqualTo(output);
    }

    @Test
    void example2() {
        int[] values = {3, 7, 4, 5};
        int output = 144;
        assertThat(s.minScoreTriangulation(values)).isEqualTo(output);
    }

    @Test
    void example3() {
        int[] values = {1, 3, 1, 4, 1, 5};
        int output = 13;
        assertThat(s.minScoreTriangulation(values)).isEqualTo(output);
    }
}