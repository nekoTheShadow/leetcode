package sum_of_distances;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void example1() {
        assertThat(new Solution().distance(new int[]{1, 3, 1, 1, 2})).isEqualTo(new long[]{5, 0, 3, 4, 0});
    }

    @Test
    void example2() {
        assertThat(new Solution().distance(new int[]{0, 5, 3})).isEqualTo(new long[]{0, 0, 0});
    }
}