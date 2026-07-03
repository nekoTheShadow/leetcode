package find_a_safe_walk_through_a_grid;

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
        List<List<Integer>> grid = toGrid("[[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]");
        int health = 1;
        assertThat(solution.findSafeWalk(grid, health)).isTrue();
    }

    @Test
    void example2() {
        List<List<Integer>> grid = toGrid("[[0,1,1,0,0,0],[1,0,1,0,0,0],[0,1,1,1,0,1],[0,0,1,0,1,0]]");
        int health = 3;
        assertThat(solution.findSafeWalk(grid, health)).isFalse();
    }


    @Test
    void example3() {
        List<List<Integer>> grid = toGrid("[[1,1,1],[1,0,1],[1,1,1]]");
        int health = 5;
        assertThat(solution.findSafeWalk(grid, health)).isTrue();
    }

    List<List<Integer>> toGrid(String grid) {
        return Pattern.compile("\\[([-+,0-9]+)\\]")
                .matcher(grid)
                .results()
                .map(m -> Pattern.compile(",").splitAsStream(m.group(1)).map(Integer::parseInt).toList())
                .toList();
    }
}