package maximum_total_damage_with_spell_casting.maximum_total_damage_with_spell_casting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    Solution s;

    @BeforeEach
    void setup() {
        s = new Solution();
    }

    @Test
    void example1() {
        int[] power = new int[]{1, 1, 3, 4};
        long output = 6;
        assertThat(s.maximumTotalDamage(power)).isEqualTo(output);
    }

    @Test
    void example2() {
        int[] power = new int[]{7, 1, 6, 6};
        long output = 13;
        assertThat(s.maximumTotalDamage(power)).isEqualTo(output);
    }
}