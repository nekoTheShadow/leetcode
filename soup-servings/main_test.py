import unittest

from main import Solution


class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.sol = Solution()

    def test_example1(self):
        self.assertAlmostEqual(self.sol.soupServings(50), 0.62500, places=5)

    def test_example2(self):
        self.assertAlmostEqual(self.sol.soupServings(100), 0.71875, places=5)
