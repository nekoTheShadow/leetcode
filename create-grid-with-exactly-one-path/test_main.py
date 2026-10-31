import unittest
from main import Solution


class SolutionTest(unittest.TestCase):
    def test_example1(self):
        self.assertTrue(check(Solution().createGrid(2, 3)))

    def test_example2(self):
        self.assertTrue(check(Solution().createGrid(3, 3)))

    def test_example3(self):
        self.assertTrue(check(Solution().createGrid(1, 4)))


def check(grid: list[str]) -> bool:
    if not grid or not grid[0]:
        return False

    m = len(grid)
    n = len(grid[0])

    # スタート地点またはゴール地点が障害物（'#'）の場合は有効なパスは0
    if grid[0][0] == "#" or grid[m - 1][n - 1] == "#":
        return False

    # DP（動的計画法）テーブルの初期化：各セルへのパスの数を記録
    # dp[i][j] は (0, 0) から (i, j) に到達する有効なパスの数
    dp = [[0] * n for _ in range(m)]
    dp[0][0] = 1

    for i in range(m):
        for j in range(n):
            # 現在のセルが障害物、またはスタート地点で既に0ならスキップ
            if grid[i][j] == "#" or dp[i][j] == 0:
                continue

            # 右へ移動できる場合
            if j + 1 < n and grid[i][j + 1] != "#":
                dp[i][j + 1] += dp[i][j]

            # 下へ移動できる場合
            if i + 1 < m and grid[i + 1][j] != "#":
                dp[i + 1][j] += dp[i][j]

    # 右上のセルに到達するパスの数がちょうど1つかどうかを返す
    return dp[m - 1][n - 1] == 1
