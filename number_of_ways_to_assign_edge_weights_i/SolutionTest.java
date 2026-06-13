package number_of_ways_to_assign_edge_weights_i;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void example1() {
        int[][] edges = {{1, 2}};
        int output = 1;
        assertThat(solution.assignEdgeWeights(edges)).isEqualTo(output);
    }


    @Test
    void example2() {
        int[][] edges = {{1, 2}, {1, 3}, {3, 4}, {3, 5}};
        int output = 2;
        assertThat(solution.assignEdgeWeights(edges)).isEqualTo(output);
    }
}