class Solution:
    def maxCollectedFruits(self, fruits: list[list[int]]) -> int:
        inf = float("inf")
        n = len(fruits)

        def dfs(
            memo: dict[tuple[int, int, int], int],
            d: list[tuple[int, int]],
            x: int,
            y: int,
            step: int,
        ) -> int:
            if step == n - 1:
                if x == y == n - 1:
                    return 0
                else:
                    return -inf

            if (x, y, step) in memo:
                return memo[(x, y, step)]

            ret = -inf
            fruit = 0 if x == y else fruits[x][y]
            for dx, dy in d:
                nx = x + dx
                ny = y + dy
                if 0 <= nx < n and 0 <= ny < n:
                    ret = max(ret, dfs(memo, d, nx, ny, step + 1) + fruit)
            memo[(x, y, step)] = ret
            return ret

        c1 = sum(fruits[i][i] for i in range(n))
        c2 = dfs(dict(), [(1, -1), (1, 0), (1, 1)], 0, n - 1, 0)
        c3 = dfs(dict(), [(-1, 1), (0, 1), (1, 1)], n - 1, 0, 0)

        return c1 + c2 + c3
