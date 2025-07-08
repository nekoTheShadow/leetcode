MOD = 10**9 + 7


class Solution:
    def possibleStringCount(self, word: str, k: int) -> int:
        counts: list[int] = []
        count = 0
        pre = ""
        for cur in word:
            if pre != cur:
                if count > 0:
                    counts.append(count)
                count = 0
            pre = cur
            count += 1
        if count > 0:
            counts.append(count)

        v1 = 1
        for count in counts:
            v1 *= count
            v1 %= MOD

        if k <= len(counts):
            return v1

        dp = [0] * k
        dp[0] = 1
        for count in counts:
            new_dp = [0] * k
            total = 0
            for i in range(k):
                if i > 0:
                    total += dp[i - 1]
                    total %= MOD
                if i - count > 0:
                    total -= dp[i - count - 1]
                    total %= MOD
                new_dp[i] = total
            dp = new_dp

        v2 = 0
        for i in range(len(counts), k):
            v2 += dp[i]
            v2 %= MOD

        return (v1 - v2) % MOD
