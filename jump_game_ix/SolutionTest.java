package jump_game_ix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution;

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 3}, new int[]{2, 2, 3}),
                Arguments.of(new int[]{2, 3, 1}, new int[]{3, 3, 3})
        );
    }

    @BeforeEach
    void beforeEach() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void example(int[] nums, int[] expected) {
        assertThat(solution.maxValue(nums)).isEqualTo(expected);
    }
}