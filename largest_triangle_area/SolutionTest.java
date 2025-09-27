package largest_triangle_area;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        int[][] points = parse("[[0,0],[0,1],[1,0],[0,2],[2,0]]");
        double output = 2.00000;
        assertThat(s.largestTriangleArea(points)).isEqualTo(output);
    }

    @Test
    void example2() {
        int[][] points = parse("[[1,0],[0,0],[0,1]]");
        double output = 0.50000;
        assertThat(s.largestTriangleArea(points)).isEqualTo(output);
    }


    private int[][] parse(String s) {
        return Pattern.compile("\\[(\\d+),(\\d+)\\]")
                .matcher(s)
                .results()
                .map(r -> new int[]{Integer.parseInt(r.group(1)), Integer.parseInt(r.group(2))})
                .toArray(int[][]::new);
    }
}