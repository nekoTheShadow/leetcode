package substring_with_largest_variance;

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
		assertEquals(3, s.largestVariance("aababbb"));
	}

	@Test
	void example2() {
		assertEquals(0, s.largestVariance("abcde"));
	}
}
