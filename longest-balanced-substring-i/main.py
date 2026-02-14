import collections


class Solution:
    def longestBalanced(self, s: str) -> int:
        n = len(s)
        mx = 0
        for i in range(n):
            d: collections.Counter[str] = collections.Counter()
            for j in range(i, n):
                d[s[j]] += 1
                if len(set(d.values())) < 2:
                    mx = max(mx, j - i + 1)
        return mx