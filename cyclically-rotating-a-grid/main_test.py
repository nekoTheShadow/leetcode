import unittest

from main import Solution


class TestSolution(unittest.TestCase):
    def setUp(self) -> None:
        self.solution = Solution()

    def test_example1(self):
        grid = [[40, 10], [30, 20]]
        k = 1
        output = [[10, 20], [40, 30]]
        self.assertEqual(self.solution.rotateGrid(grid, k), output)

    def test_example2(self):
        grid = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
        k = 2
        output = [[3, 4, 8, 12], [2, 11, 10, 16], [1, 7, 6, 15], [5, 9, 13, 14]]
        self.assertEqual(self.solution.rotateGrid(grid, k), output)
