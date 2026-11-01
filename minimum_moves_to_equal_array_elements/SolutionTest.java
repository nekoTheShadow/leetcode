package minimum_moves_to_equal_array_elements;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void example1() {
        assertThat(new Solution().minMoves(new int[]{1, 2, 3})).isEqualTo(3);
    }

    @Test
    void example2() {
        assertThat(new Solution().minMoves(new int[]{1, 1, 1})).isEqualTo(0);
    }
}