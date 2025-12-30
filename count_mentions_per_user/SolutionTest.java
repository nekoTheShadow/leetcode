package count_mentions_per_user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Gatherers;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    Solution s;

    @BeforeEach
    void setup() {
        s = new Solution();
    }

    @Test
    void example1() {
        int numberOfUsers = 2;
        String events = """
                [["MESSAGE","10","id1 id0"],["OFFLINE","11","0"],["MESSAGE","71","HERE"]]
                """;
        int[] output = {2, 2};
        assertThat(s.countMentions(numberOfUsers, matrix(events))).isEqualTo(output);
    }

    @Test
    void example2() {
        int numberOfUsers = 2;
        String events = """
                [["MESSAGE","10","id1 id0"],["OFFLINE","11","0"],["MESSAGE","12","ALL"]]
                """;
        int[] output = {2, 2};
        assertThat(s.countMentions(numberOfUsers, matrix(events))).isEqualTo(output);
    }

    @Test
    void example3() {
        int numberOfUsers = 2;
        String events = """
                [["OFFLINE","10","0"],["MESSAGE","12","HERE"]]
                """;
        int[] output = {0, 1};
        assertThat(s.countMentions(numberOfUsers, matrix(events))).isEqualTo(output);
    }

    List<List<String>> matrix(String line) {
        return Pattern.compile("\"(.+?)\"")
                .matcher(line.trim())
                .results()
                .map(mr -> mr.group(1))
                .gather(Gatherers.windowFixed(3))
                .toList();
    }
}