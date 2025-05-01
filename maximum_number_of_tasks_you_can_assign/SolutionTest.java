package maximum_number_of_tasks_you_can_assign;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

  Solution s;

  @BeforeEach
  void setup() {
    s = new Solution();
  }

  @Test
  void example1() {
    int[] tasks = new int[] {3, 2, 1};
    int[] workers = new int[] {0, 3, 3};
    int pills = 1;
    int strength = 1;
    assertEquals(3, s.maxTaskAssign(tasks, workers, pills, strength));
  }

  @Test
  void example2() {
    int[] tasks = new int[] {5, 4};
    int[] workers = new int[] {0, 0, 0};
    int pills = 1;
    int strength = 5;
    assertEquals(1, s.maxTaskAssign(tasks, workers, pills, strength));
  }

  @Test
  void example3() {
    int[] tasks = new int[] {10, 15, 30};
    int[] workers = new int[] {0, 10, 10, 10, 10};
    int pills = 3;
    int strength = 10;
    assertEquals(2, s.maxTaskAssign(tasks, workers, pills, strength));
  }

  @Test
  void ng1() {
    int[] tasks = new int[] {35};
    int[] workers = new int[] {83, 20, 4, 66};
    int pills = 3;
    int strength = 41;
    assertEquals(1, s.maxTaskAssign(tasks, workers, pills, strength));
  }

  @Test
  void ng2() {
    int[] tasks = new int[] {74, 41, 64, 20, 28, 52, 30, 4, 4, 63};
    int[] workers = new int[] {38};
    int pills = 0;
    int strength = 68;
    assertEquals(1, s.maxTaskAssign(tasks, workers, pills, strength));
  }
}
