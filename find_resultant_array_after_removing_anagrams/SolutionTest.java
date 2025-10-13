package find_resultant_array_after_removing_anagrams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    Solution s;

    @BeforeEach
    void setup() {
        s = new Solution();
    }

    @Test
    void example1() {
        String[] words = new String[]{"abba", "baba", "bbaa", "cd", "cd"};
        List<String> output = List.of("abba", "cd");
        assertThat(s.removeAnagrams(words)).isEqualTo(output);
    }

    @Test
    void example2() {
        String[] words = new String[]{"a", "b", "c", "d", "e"};
        List<String> output = List.of("a", "b", "c", "d", "e");
        assertThat(s.removeAnagrams(words)).isEqualTo(output);
    }
}