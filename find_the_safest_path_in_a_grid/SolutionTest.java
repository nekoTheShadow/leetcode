package find_the_safest_path_in_a_grid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
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
        List<List<Integer>> grid = toMatrix("[[1,0,0],[0,0,0],[0,0,1]]");
        assertThat(solution.maximumSafenessFactor(grid)).isEqualTo(0);
    }


    @Test
    void example2() {
        List<List<Integer>> grid = toMatrix("[[0,0,1],[0,0,0],[0,0,0]]");
        assertThat(solution.maximumSafenessFactor(grid)).isEqualTo(2);
    }

    @Test
    void example3() {
        List<List<Integer>> grid = toMatrix("[[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]");
        assertThat(solution.maximumSafenessFactor(grid)).isEqualTo(2);
    }


    private List<List<Integer>> toMatrix(String grid) {
        return Pattern.compile("\\[([-+,0-9]+)\\]")
                .matcher(grid)
                .results()
                .map(m -> Pattern.compile(",").splitAsStream(m.group(1))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .toList())
                .toList();
    }
}