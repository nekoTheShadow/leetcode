package smallest_sufficient_team;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Collectors;

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
		String[] req_skills = { "java", "nodejs", "reactjs" };
		String[][] people = { { "java" }, { "nodejs" }, { "nodejs", "reactjs" } };
		int[] expected = { 0, 2 };
		int[] actual = s.smallestSufficientTeam(req_skills,
				Arrays.stream(people).map(Arrays::asList).collect(Collectors.toList()));
		Arrays.sort(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	void example2() {
		String[] req_skills = { "algorithms", "math", "java", "reactjs", "csharp", "aws" };
		String[][] people = { { "algorithms", "math", "java" }, { "algorithms", "math", "reactjs" },
				{ "java", "csharp", "aws" }, { "reactjs", "csharp" }, { "csharp", "math" }, { "aws", "java" } };
		int[] expected = { 1, 2 };
		int[] actual = s.smallestSufficientTeam(req_skills,
				Arrays.stream(people).map(Arrays::asList).collect(Collectors.toList()));
		Arrays.sort(actual);
		assertArrayEquals(expected, actual);
	}
}
