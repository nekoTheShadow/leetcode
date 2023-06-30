package last_day_where_you_can_still_cross;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

	Solution solution;

	@BeforeEach
	void setUp() {
		solution = new Solution();
	}

	@Test
	void example1() {
		int row = 2;
		int col = 2;
		int[][] cells = { { 1, 1 }, { 2, 1 }, { 1, 2 }, { 2, 2 } };
		assertEquals(2, solution.latestDayToCross(row, col, cells));
	}

	@Test
	void example2() {
		int row = 2;
		int col = 2;
		int[][] cells = { { 1, 1 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };
		assertEquals(1, solution.latestDayToCross(row, col, cells));
	}

	@Test
	void example3() {
		int row = 3;
		int col = 3;
		int[][] cells = { { 1, 2 }, { 2, 1 }, { 3, 3 }, { 2, 2 }, { 1, 1 }, { 1, 3 }, { 2, 3 }, { 3, 2 }, { 3, 1 } };
		assertEquals(3, solution.latestDayToCross(row, col, cells));
	}
}
