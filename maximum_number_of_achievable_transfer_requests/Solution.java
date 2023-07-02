package maximum_number_of_achievable_transfer_requests;

import java.util.Arrays;

public class Solution {
	public int maximumRequests(int n, int[][] requests) {
		int ret = 0;
		long m = requests.length;
		for (long bit = 0; bit < (1 << m); bit++) {
			long[] g = new long[n];
			for (int i = 0; i < m; i++) {
				if ((bit & (1 << i)) != 0) {
					int[] request = requests[i];
					g[request[0]]--;
					g[request[1]]++;
				}
			}

			if (Arrays.stream(g).allMatch(v -> v == 0)) {
				ret = Math.max(ret, Long.bitCount(bit));
			}
		}
		return ret;
	}
}
