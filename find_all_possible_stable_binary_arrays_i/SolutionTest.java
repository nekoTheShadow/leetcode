package find_all_possible_stable_binary_arrays_i;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    Solution soluton;

    @BeforeEach
    void setup() {
        soluton = new Solution();
    }

    @Test
    void example1() {
        assertThat(soluton.numberOfStableArrays(1, 1, 2)).isEqualTo(2);
    }

    @Test
    void example2() {
        assertThat(soluton.numberOfStableArrays(1, 2, 1)).isEqualTo(1);
    }


    @Test
    void example3() {
        assertThat(soluton.numberOfStableArrays(3, 3, 2)).isEqualTo(14);
    }

    @Test
    void ng1() {
        assertThat(soluton.numberOfStableArrays(58, 53, 83)).isEqualTo(28909891);
    }

    @Test
    void ng2() {
        assertThat(soluton.numberOfStableArrays(200, 200, 25)).isEqualTo(292126791);
    }
}