package smallest_sufficient_team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution {
	private List<String> req_skills;
	private long[] people;
	private Map<Key, List<Integer>> memo;

	public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
		this.req_skills = Arrays.asList(req_skills);
		this.people = new long[people.size()];
		for (int i = 0; i < people.size(); i++) {
			for (String skill : people.get(i)) {
				this.people[i] |= 1 << (this.req_skills.indexOf(skill));
			}
		}
		this.memo = new HashMap<>();

		List<Integer> ret = f(0, 0);
		return ret.stream().mapToInt(Integer::intValue).toArray();
	}

	public List<Integer> f(int cur, long bit) {
		// すべてのスキルが採用済み
		if (bit == (1 << req_skills.size()) - 1) {
			return Collections.emptyList();
		}

		// すべてのスキルを採用できないうちに探索が完了した
		if (cur == people.length) {
			return IntStream.range(0, 100).boxed().toList();
		}

		// memo
		Key key = new Key(cur, bit);
		if (memo.containsKey(key)) {
			return memo.get(key);
		}

		List<Integer> ret1 = f(cur + 1, bit); // 採用しない
		List<Integer> ret2 = new ArrayList<>(); // 採用する
		ret2.addAll(f(cur + 1, bit | people[cur]));
		ret2.add(cur);
		List<Integer> ret = ret1.size() < ret2.size() ? ret1 : ret2;
		memo.put(key, ret);
		return ret;
	}

	public record Key(int cur, long bit) {

	}
}
