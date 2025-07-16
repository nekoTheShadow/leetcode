from typing import List


class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        # 1. 偶数→偶数→偶数→偶数 ...
        # 2. 奇数→奇数→奇数→奇数 ...
        # 3. 奇数→偶数→奇数→偶数 ...
        n1 = sum(1 for num in nums if num % 2 == 0)
        n2 = sum(1 for num in nums if num % 2 != 0)

        seq: list[int] = []
        for num in nums:
            if len(seq) == 0 or seq[-1] % 2 != num % 2:
                seq.append(num)
        n3 = len(seq)

        return max(n1, n2, n3)
