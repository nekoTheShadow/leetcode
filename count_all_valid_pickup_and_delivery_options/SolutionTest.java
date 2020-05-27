package count_all_valid_pickup_and_delivery_options;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = new Solution();
    }

    @Test
    void exapmle1() {
        assertEquals(1, solution.countOrders(1));
    }

    @Test
    void exapmle2() {
        assertEquals(6, solution.countOrders(2));
    }

    @Test
    void exapmle3() {
        assertEquals(90, solution.countOrders(3));
    }
}
