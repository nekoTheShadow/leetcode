package fraction_to_recurring_decimal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void example1() {
        assertThat(new Solution().fractionToDecimal(1, 2)).isEqualTo("0.5");
    }

    @Test
    void example2() {
        assertThat(new Solution().fractionToDecimal(2, 1)).isEqualTo("2");
    }

    @Test
    void example3() {
        assertThat(new Solution().fractionToDecimal(4, 333)).isEqualTo("0.(012)");
    }

    @Test
    void ng1() {
        assertThat(new Solution().fractionToDecimal(-1, -2147483648

        )).isEqualTo("0.0000000004656612873077392578125");
    }
}