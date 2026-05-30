package longest_common_suffix_queries;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void example1() {
        String[] wordsContainer = {"abcd", "bcd", "xbcd" };
        String[] wordsQuery = {"cd", "bcd", "xyz" };
        int[] output = {1, 1, 1};
        assertThat(new Solution().stringIndices(wordsContainer, wordsQuery)).isEqualTo(output);
    }

    @Test
    void example2() {
        String[] wordsContainer = {"abcdefgh", "poiuygh", "ghghgh" };
        String[] wordsQuery = {"gh", "acbfgh", "acbfegh" };
        int[] output = {2, 0, 2};
        assertThat(new Solution().stringIndices(wordsContainer, wordsQuery)).isEqualTo(output);
    }
}