package lexicographically_smallest_generated_string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void example1() {
        String str1 = "TFTF";
        String str2 = "ab";
        String output = "ababa";
        assertThat(solution.generateString(str1, str2)).isEqualTo(output);
    }


    @Test
    void example2() {
        String str1 = "TFTF";
        String str2 = "abc";
        String output = "";
        assertThat(solution.generateString(str1, str2)).isEqualTo(output);
    }


    @Test
    void example3() {
        String str1 = "F";
        String str2 = "d";
        String output = "a";
        assertThat(solution.generateString(str1, str2)).isEqualTo(output);
    }
}