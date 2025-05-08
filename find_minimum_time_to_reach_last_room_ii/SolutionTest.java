package find_minimum_time_to_reach_last_room_ii;

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
    assertEquals(7, s.minTimeToReach(new int[][] {{0, 4}, {4, 4}}));
  }

  @Test
  void example2() {
    assertEquals(6, s.minTimeToReach(new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}}));
  }

  @Test
  void example3() {
    assertEquals(4, s.minTimeToReach(new int[][] {{0, 1}, {1, 2}}));
  }
}
