package swim_in_rising_water;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    Solution s;

    @BeforeEach
    void setup() {
        s = new Solution();
    }

    @Test
    void example1() {
        String input = "[[0,2],[1,3]]";
        int output = 3;
        assertThat(s.swimInWater(parse(input))).isEqualTo(output);
    }

    @Test
    void example2() {
        String input = " [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]";
        int output = 16;
        assertThat(s.swimInWater(parse(input))).isEqualTo(output);
    }

    private int[][] parse(String input) {
        List<int[]> matrix = new ArrayList<>();
        Matcher m = Pattern.compile("\\[([0-9,]*)\\]").matcher(input);
        while (m.find()) {
            int[] row = Pattern.compile(",").splitAsStream(m.group(1)).mapToInt(Integer::parseInt).toArray();
            matrix.add(row);
        }
        return matrix.toArray(int[][]::new);
    }
}