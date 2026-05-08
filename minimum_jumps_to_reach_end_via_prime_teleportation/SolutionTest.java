package minimum_jumps_to_reach_end_via_prime_teleportation;

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
        int[] nums = {1, 2, 4, 6};
        int output = 2;
        assertThat(solution.minJumps(nums)).isEqualTo(output);
    }


    @Test
    void example2() {
        int[] nums = {2, 3, 4, 7, 9};
        int output = 2;
        assertThat(solution.minJumps(nums)).isEqualTo(output);
    }

    @Test
    void example3() {
        int[] nums = {4, 6, 5, 8};
        int output = 3;
        assertThat(solution.minJumps(nums)).isEqualTo(output);
    }

}