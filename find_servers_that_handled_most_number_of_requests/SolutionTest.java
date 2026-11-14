package find_servers_that_handled_most_number_of_requests;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void example1() {
        int k = 3;
        int[] arrival = new int[]{1, 2, 3, 4, 5};
        int[] load = new int[]{5, 2, 3, 3, 3};
        assertThat(new Solution().busiestServers(k, arrival, load)).isEqualTo(List.of(1));
    }

    @Test
    void example2() {
        int k = 3;
        int[] arrival = new int[]{1, 2, 3, 4};
        int[] load = new int[]{1, 2, 1, 2};
        assertThat(new Solution().busiestServers(k, arrival, load)).isEqualTo(List.of(0));
    }

    @Test
    void example3() {
        int k = 3;
        int[] arrival = new int[]{1, 2, 3};
        int[] load = new int[]{10, 12, 11};
        assertThat(new Solution().busiestServers(k, arrival, load)).isEqualTo(List.of(0, 1, 2));
    }

    @Test
    void ng1() {
        int k = 2;
        int[] arrival = new int[]{2, 3, 4, 8};
        int[] load = new int[]{3, 2, 4, 3};
        assertThat(new Solution().busiestServers(k, arrival, load)).isEqualTo(List.of(1));
    }
}