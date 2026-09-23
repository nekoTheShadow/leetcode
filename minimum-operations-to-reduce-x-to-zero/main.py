class Solution:

    def minOperations(self, nums: list[int], x: int) -> int:
        INF = 10**9 + 7
        n = len(nums)

        d = [0] * (n + 1)
        for i in range(n):
            d[i + 1] = d[i] + nums[i]

        target = sum(nums) - x
        h: dict[int, int] = {}
        h[0] = 0
        ret = INF
        for i in range(n + 1):
            if d[i] - target in h:
                ret = min(ret, n - (i - h[d[i] - target]))

            if not d[i] in h:
                h[d[i]] = i

        if ret == INF:
            return -1
        else:
            return ret
