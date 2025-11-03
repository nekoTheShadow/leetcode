package find_sum_of_array_product_of_magical_sequences;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void testMagicalSum_example1() {
        int m = 5;
        int k = 5;
        int[] nums = {1, 10, 100, 10000, 1000000};
        int expected = 991600007;
        assertThat(solution.magicalSum(m, k, nums)).isEqualTo(expected);
    }

    @Test
    void testMagicalSum_example2() {
        int m = 2;
        int k = 2;
        int[] nums = {5, 4, 3, 2, 1};
        int expected = 170;
        assertThat(solution.magicalSum(m, k, nums)).isEqualTo(expected);
    }

    @Test
    void testMagicalSum_example3() {
        int m = 1;
        int k = 1;
        int[] nums = {28};
        int expected = 28;
        assertThat(solution.magicalSum(m, k, nums)).isEqualTo(expected);
    }
}
