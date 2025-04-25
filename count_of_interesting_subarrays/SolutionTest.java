package count_of_interesting_subarrays;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
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
    assertEquals(3, s.countInterestingSubarrays(List.of(3,2,4), 2, 1));
  }

  @Test
  void example2() {
    assertEquals(2, s.countInterestingSubarrays(List.of(3,1,9,6), 3, 0));
  } 
}
