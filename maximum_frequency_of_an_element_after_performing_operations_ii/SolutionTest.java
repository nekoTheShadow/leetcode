package maximum_frequency_of_an_element_after_performing_operations_ii;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    static Stream<Arguments> args() {
        return Stream.of(
                arguments("example1", new int[]{1, 4, 5}, 1, 2, 2),
                arguments("example1", new int[]{5, 11, 20, 20}, 5, 1, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void example(String message, int[] nums, int k, int numOperations, int output) {
        Solution solution = new Solution();
        assertThat(solution.maxFrequency(nums, k, numOperations))
                .withFailMessage(message)
                .isEqualTo(output);
    }
}