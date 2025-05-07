package find_minimum_time_to_reach_last_room_i;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

  Solution s;

  @BeforeEach
  void setUp() {
    s = new Solution();
  }

  @Test
  void example1() {
    assertEquals(6, s.minTimeToReach(new int[][] {{0, 4}, {4, 4}}));
  }

  @Test
  void example2() {
    assertEquals(3, s.minTimeToReach(new int[][] {{0, 0, 0}, {0, 0, 0}}));
  }

  @Test
  void example3() {
    assertEquals(3, s.minTimeToReach(new int[][] {{0, 1}, {1, 2}}));
  }
}
