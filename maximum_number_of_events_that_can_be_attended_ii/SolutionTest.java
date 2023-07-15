package maximum_number_of_events_that_can_be_attended_ii;

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
		int[][] events = { { 1, 2, 4 }, { 3, 4, 3 }, { 2, 3, 1 } };
		int k = 2;
		assertEquals(7, s.maxValue(events, k));
	}

	@Test
	void example2() {
		int[][] events = { { 1, 2, 4 }, { 3, 4, 3 }, { 2, 3, 10 } };
		int k = 2;
		assertEquals(10, s.maxValue(events, k));
	}

	@Test
	void example3() {
		int[][] events = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 }, { 4, 4, 4 } };
		int k = 3;
		assertEquals(9, s.maxValue(events, k));
	}
}
