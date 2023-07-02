package maximum_number_of_achievable_transfer_requests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void example1() {
		Solution solution = new Solution();
		int n = 5;
		int[][] requests = { { 0, 1 }, { 1, 0 }, { 0, 1 }, { 1, 2 }, { 2, 0 }, { 3, 4 } };
		assertEquals(5, solution.maximumRequests(n, requests));
	}

	@Test
	void example2() {
		Solution solution = new Solution();
		int n = 3;
		int[][] requests = { { 0, 0 }, { 1, 2 }, { 2, 1 } };
		assertEquals(3, solution.maximumRequests(n, requests));
	}

	@Test
	void example3() {
		Solution solution = new Solution();
		int n = 4;
		int[][] requests = { { 0, 3 }, { 3, 1 }, { 1, 2 }, { 2, 0 } };
		assertEquals(4, solution.maximumRequests(n, requests));
	}

}
