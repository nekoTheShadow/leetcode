from functools import cache


class Solution:
    def minCost(self, grid: list[list[int]]) -> int:
        h = len(grid)
        w = len(grid[0])

        @cache
        def dfs(x: int, y: int, score: int) -> int:
            score ^= grid[x][y]

            if x == h - 1 and y == w - 1:
                return score

            ret = 3000
            if x + 1 < h:
                ret = min(ret, dfs(x + 1, y, score))
            if y + 1 < w:
                ret = min(ret, dfs(x, y + 1, score))
            return ret

        ans = dfs(0, 0, 0)
        dfs.cache_clear()
        return ans
