package number_of_sets_of_k_non_overlapping_line_segments;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void example1() {
        assertThat(new Solution().numberOfSets(4, 2)).isEqualTo(5);
    }

    @Test
    void example2() {
        assertThat(new Solution().numberOfSets(3, 1)).isEqualTo(3);
    }

    @Test
    void example3() {
        assertThat(new Solution().numberOfSets(30, 7)).isEqualTo(796297179);
    }
}