import unittest


class Solution:
    def maxSideLength(self, mat: list[list[int]], threshold: int) -> int:
        h = len(mat)
        w = len(mat[0])

        ruiseki = Ruiseki(mat)
        max_l = 0
        for i in range(h):
            for j in range(w):
                ok = -1
                ng = min(h - i, w - j) + 1
                while abs(ok - ng) > 1:
                    mi = (ok + ng) // 2
                    if ruiseki.sum(i, j, i + mi, j + mi) <= threshold:
                        ok = mi
                    else:
                        ng = mi
                max_l = max(max_l, ok)
        return max_l


class Ruiseki:
    def __init__(self, a: list[list[int]]) -> None:
        h = len(a)
        w = len(a[0])
        s = [[0] * (w + 1) for _ in range(h + 1)]
        for i in range(h):
            for j in range(w):
                s[i + 1][j + 1] = s[i][j + 1] + s[i + 1][j] - s[i][j] + a[i][j]
        self.s = s

    def sum(self, x1: int, y1: int, x2: int, y2: int) -> int:
        return self.s[x2][y2] - self.s[x1][y2] - self.s[x2][y1] + self.s[x1][y1]


class SolutionTest(unittest.TestCase):
    def setUp(self) -> None:
        self.solution = Solution()

    def test_example1(self):
        mat = [[1, 1, 3, 2, 4, 3, 2], [1, 1, 3, 2, 4, 3, 2], [1, 1, 3, 2, 4, 3, 2]]
        threshold = 4
        output = 2
        self.assertEqual(self.solution.maxSideLength(mat, threshold), output)

    def test_example2(self):
        mat = [
            [2, 2, 2, 2, 2],
            [2, 2, 2, 2, 2],
            [2, 2, 2, 2, 2],
            [2, 2, 2, 2, 2],
            [2, 2, 2, 2, 2],
        ]
        threshold = 1
        output = 0
        self.assertEqual(self.solution.maxSideLength(mat, threshold), output)
