from typing import List
import unittest


class Solution:
    def uniquePaths(self, grid: List[List[int]]) -> int:
        h = len(grid)
        w = len(grid[0])

        def nxt(x: int, y: int, dx: int, dy: int) -> tuple[int, int]:
            nx = x + dx
            ny = y + dy
            if 0 <= nx < h and 0 <= ny < w and grid[nx][ny] == 1:
                return nxt(nx, ny, dy, dx)
            return (nx, ny)

        dp = [[0] * w for _ in range(h)]
        dp[0][0] = 1
        for x in range(h):
            for y in range(w):
                if grid[x][y] == 1:
                    continue

                for dx, dy in ((0, 1), (1, 0)):
                    nx, ny = nxt(x, y, dx, dy)
                    if 0 <= nx < h and 0 <= ny < w:
                        dp[nx][ny] += dp[x][y]
                        dp[nx][ny] %= 10**9 + 7
        return dp[h - 1][w - 1]


class SolutionTest(unittest.TestCase):
    def test_example1(self):
        grid = [[0, 1, 0], [0, 0, 1], [1, 0, 0]]
        self.assertEqual(Solution().uniquePaths(grid), 5)

    def test_example2(self):
        grid = [[0, 0], [0, 0]]
        self.assertEqual(Solution().uniquePaths(grid), 2)

    def test_example3(self):
        grid = [[0, 1, 1], [1, 1, 0]]
        self.assertEqual(Solution().uniquePaths(grid), 1)


if __name__ == "__main__":
    unittest.main()
