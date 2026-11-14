package climbing_stairs_ii;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void test1() {
        int n = 4;
        int[] costs = new int[]{1, 2, 3, 4};
        assertThat(new Solution().climbStairs(n, costs)).isEqualTo(13);
    }

    @Test
    void test2() {
        int n = 4;
        int[] costs = new int[]{5, 1, 6, 2};
        assertThat(new Solution().climbStairs(n, costs)).isEqualTo(11);
    }

    @Test
    void test3() {
        int n = 3;
        int[] costs = new int[]{9, 8, 3};
        assertThat(new Solution().climbStairs(n, costs)).isEqualTo(12);
    }
}