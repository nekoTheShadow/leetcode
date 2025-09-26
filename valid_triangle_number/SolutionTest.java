package valid_triangle_number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SolutionTest {

    Solution s;

    @BeforeEach
    void setup() {
        s = new Solution();
    }

    @Test
    void example1() {
        int[] nums = new int[]{2, 2, 3, 4};
        int output = 3;
        assertThat(s.triangleNumber(nums)).isEqualTo(output);
    }

    @Test
    void example2() {
        int[] nums = new int[]{4, 2, 3, 4};
        int output = 4;
        assertThat(s.triangleNumber(nums)).isEqualTo(output);
    }
}