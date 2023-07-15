package maximum_number_of_events_that_can_be_attended_ii;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	private int[][] events;
	private int n;
	private int[][] memo;

	public int maxValue(int[][] events, int k) {
		this.n = events.length;
		this.events = events;
		this.memo = new int[n][k + 1];

		Arrays.sort(this.events, Comparator.comparing(event -> event[0]));
		for (int[] row : this.memo) {
			Arrays.fill(row, -1);
		}
		return f(0, k);
	}

	public int f(int cur, int k) {
		if (n == cur || k == 0) {
			return 0;
		}

		if (memo[cur][k] != -1) {
			return memo[cur][k];
		}

		int nxt = n;
		for (int i = cur + 1; i < n; i++) {
			if (events[cur][1] < events[i][0]) {
				nxt = i;
				break;
			}
		}

		memo[cur][k] = Math.max(f(cur + 1, k), f(nxt, k - 1) + events[cur][2]);
		return memo[cur][k];
	}
}
