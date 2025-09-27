package find_closest_person;

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
        int x = 2, y = 7, z = 4;
        int output = 1;
        assertThat(s.findClosest(x, y, z)).isEqualTo(output);
    }

    @Test
    void example2() {
        int x = 2, y = 5, z = 6;
        int output = 2;
        assertThat(s.findClosest(x, y, z)).isEqualTo(output);
    }

    @Test
    void example3() {
        int x = 1, y = 5, z = 3;
        int output = 0;
        assertThat(s.findClosest(x, y, z)).isEqualTo(output);
    }
}