package taking_maximum_energy_from_the_mystic_dungeon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution s;

    @BeforeEach
    void setUp() {
        s = new Solution();
    }

    @Test
    void example1() {
        int[] energy = new int[]{5, 2, -10, -5, 1};
        int k = 3;
        int output = 3;
        assertThat(s.maximumEnergy(energy, k)).isEqualTo(output);
    }

    @Test
    void example2() {
        int[] energy = new int[]{-2, -3, -1};
        int k = 2;
        int output = -1;
        assertThat(s.maximumEnergy(energy, k)).isEqualTo(output);
    }
}