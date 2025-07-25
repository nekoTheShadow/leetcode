import functools
import operator
from typing import List


class Solution:
    def minimumScore(self, nums: List[int], edges: List[List[int]]) -> int:
        def dfs1(cur: int, pre: int) -> int:
            res = nums[cur]
            for nxt in g[cur]:
                if nxt == pre:
                    continue
                res ^= dfs1(nxt, cur)
            return res

        def dfs2(cur: int, pre: int) -> int:
            nonlocal s, s1, ans
            res = nums[cur]
            for nxt in g[cur]:
                if nxt == pre:
                    continue
                s2 = dfs2(nxt, cur)
                res ^= s2
                mx = max(s ^ s1, s2, s1 ^ s2)
                mn = min(s ^ s1, s2, s1 ^ s2)
                ans = min(ans, mx - mn)
            return res

        n = len(nums)
        g: list[list[int]] = [[] for _ in range(n)]
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)
        s = functools.reduce(operator.xor, nums)
        ans = 10**9 + 7

        for u in range(n):
            for v in g[u]:
                s1 = dfs1(u, v)
                dfs2(u, v)

        return ans
