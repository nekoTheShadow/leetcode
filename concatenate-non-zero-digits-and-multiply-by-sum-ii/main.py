from typing import List


class Solution:
    def sumAndMultiply(self, s: str, queries: List[List[int]]) -> List[int]:
        MOD = 1_000_000_000 + 7

        digits = list(map(int, s))
        n = len(digits)

        d1 = [0] * (n + 1)
        d2 = [0] * (n + 1)
        q2 = [0] * (n + 1)
        for i in range(n):
            d1[i + 1] = d1[i] + digits[i]
            if digits[i] == 0:
                q2[i + 1] = q2[i]
            else:
                q2[i + 1] = q2[i] + 1
            if digits[i] == 0:
                d2[i + 1] = d2[i]
            else:
                d2[i + 1] = d2[i] * 10 + digits[i]
                d2[i + 1] %= MOD

        p2 = [1] * (n + 1)
        for i in range(1, n + 1):
            p2[i] = p2[i - 1] * 10
            p2[i] %= MOD

        ans: list[int] = []
        for query in queries:
            l = query[0]
            r = query[1]
            t1 = d1[r + 1] - d1[l]
            t2 = d2[r + 1] - (d2[l] * p2[q2[r + 1] - q2[l]] % MOD) % MOD
            ans.append(t1 * t2 % MOD)
        return ans
