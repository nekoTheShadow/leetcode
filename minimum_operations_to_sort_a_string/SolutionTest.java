package minimum_operations_to_sort_a_string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("dog", 1),
                Arguments.of("card", 2),
                Arguments.of("gf", -1)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void test(String s, int output) {
        assertThat(new Solution().minOperations(s)).isEqualTo(output);
    }
}