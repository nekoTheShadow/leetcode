package minimum_moves_to_equal_array_elements_iii;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void example1() {
        assertThat(new Solution().minMoves(new int[]{2, 1, 3})).isEqualTo(3);
    }

    @Test
    void example2() {
        assertThat(new Solution().minMoves(new int[]{4, 4, 5})).isEqualTo(2);
    }
}