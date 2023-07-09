package substring_with_largest_variance;

public class Solution {
	public int largestVariance(String s) {
		int n = s.length();
		long ret = 0;
		long[] d = new long[26];
		for (int i = 0; i < n; i++) {
			d[s.charAt(i) - 'a']++;
		}
		for (char a = 'a'; a <= 'z'; a++) {
			for (char b = 'a'; b <= 'z'; b++) {
				if (a == b || d[a - 'a'] == 0 || d[b - 'a'] == -1) {
					continue;
				}

				long curA = 0L;
				long curB = 0L;
				long remA = d[a - 'a'];

				for (int i = 0; i < n; i++) {
					char ch = s.charAt(i);
					if (ch == a) {
						curA++;
						remA--;
					}
					if (ch == b) {
						curB++;
					}
					if (curA > 0) {
						ret = Math.max(ret, curB - curA);
					}
					if (curB < curA && remA >= 1) {
						curA = 0;
						curB = 0;
					}
				}
			}
		}
		return (int) ret;
	}
}
