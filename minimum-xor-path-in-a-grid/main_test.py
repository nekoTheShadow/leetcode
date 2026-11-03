import unittest

from main import Solution


class SolutionTest(unittest.TestCase):
    def test_example1(self):
        grid = [[1, 2], [3, 4]]
        output = 6
        self.assertEqual(Solution().minCost(grid), output)

    def test_example2(self):
        grid = [[6, 7], [5, 8]]
        output = 9
        self.assertEqual(Solution().minCost(grid), output)

    def test_example3(self):
        grid = [[2, 7, 5]]
        output = 0
        self.assertEqual(Solution().minCost(grid), output)
