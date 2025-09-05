import unittest

from main import Solution


class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.sol = Solution()

    def test_example1(self):
        self.assertEqual(self.sol.makeTheIntegerZero(3, -2), 3)

    def test_example2(self):
        self.assertEqual(self.sol.makeTheIntegerZero(5, 7), -1)

    def test_ng(self):
        self.assertEqual(self.sol.makeTheIntegerZero(110, 55), -1)
