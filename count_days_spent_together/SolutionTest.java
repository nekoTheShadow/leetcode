package count_days_spent_together;

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
        var arriveAlice = "08-15";
        var leaveAlice = "08-18";
        var arriveBob = "08-16";
        var leaveBob = "08-19";
        int output = 3;
        assertThat(solution.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob)).isEqualTo(output);
    }

    @Test
    void example2() {
        var arriveAlice = "10-01";
        var leaveAlice = "10-31";
        var arriveBob = "11-01";
        var leaveBob = "12-31";
        int output = 0;
        assertThat(solution.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob)).isEqualTo(output);
    }
}