import itertools
from typing import List


class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        dp = [[0] * k for _ in range(k)]
        for num in nums:
            for pre_mod in range(k):
                dp[pre_mod][num % k] = dp[num % k][pre_mod] + 1
        return max(itertools.chain.from_iterable(dp))
