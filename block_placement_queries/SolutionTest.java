package block_placement_queries;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void example1() {
        String queries = "[[1,2],[2,3,3],[2,3,1],[2,2,2]]";
        List<Boolean> output = List.of(false, true, true);
        assertThat(new Solution().getResults(toGrid(queries))).isEqualTo(output);
    }


    @Test
    void example2() {
        String queries = "[[1,7],[2,7,6],[1,2],[2,7,5],[2,7,6]]";
        List<Boolean> output = List.of(true, true, false);
        assertThat(new Solution().getResults(toGrid(queries))).isEqualTo(output);
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