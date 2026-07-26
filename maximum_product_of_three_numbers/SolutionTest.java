package maximum_product_of_three_numbers;

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
        assertThat(solution.maximumProduct(new int[]{1, 2, 3})).isEqualTo(6);
    }

    @Test
    void example2() {
        assertThat(solution.maximumProduct(new int[]{1, 2, 3, 4})).isEqualTo(24);
    }


    @Test
    void example3() {
        assertThat(solution.maximumProduct(new int[]{-1, -2, -3})).isEqualTo(-6);
    }
}