package calculate_money_in_leetcode_bank;

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
        assertThat(solution.totalMoney(4)).isEqualTo(10);
    }

    @Test
    void example2() {
        assertThat(solution.totalMoney(10)).isEqualTo(37);
    }

    @Test
    void example3() {
        assertThat(solution.totalMoney(20)).isEqualTo(96);
    }
}