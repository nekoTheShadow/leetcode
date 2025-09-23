package count_submatrices_with_all_ones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution s;

    @BeforeEach
    void setup() {
        s = new Solution();
    }

    @Test
    void example1() {
        String mat = "[[1,0,1],[1,1,0],[1,1,0]]";
        int output = 13;
        assertEquals(output, s.numSubmat(parse(mat)));
    }

    @Test
    void example2() {
        String mat = "[[0,1,1,0],[0,1,1,1],[1,1,1,0]]";
        int output = 24;
        assertEquals(output, s.numSubmat(parse(mat)));
    }

    int[][] parse(String mat) {
        List<int[]> matrix = new ArrayList<>();
        Matcher m = Pattern.compile("\\[([0-9,]*)\\]").matcher(mat);
        while (m.find()) {
            matrix.add(Pattern.compile(",").splitAsStream(m.group(1)).mapToInt(Integer::parseInt).toArray());
        }
        return matrix.toArray(int[][]::new);
    }
}