package minimum_moves_to_clean_the_classroom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        String[] classroom = {"S.", "XL"};
        int energy = 2;

        assertThat(solution.minMoves(classroom, energy))
                .isEqualTo(2);
    }

    @Test
    void example2() {
        String[] classroom = {"LS", "RL"};
        int energy = 4;

        assertThat(solution.minMoves(classroom, energy))
                .isEqualTo(3);
    }

    @Test
    void example3() {
        String[] classroom = {"L.S", "RXL"};
        int energy = 3;

        assertThat(solution.minMoves(classroom, energy))
                .isEqualTo(-1);
    }
}