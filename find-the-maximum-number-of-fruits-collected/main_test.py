import unittest

from main import Solution


class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.sol = Solution()

    def test_example1(self):
        fruits = [[1, 2, 3, 4], [5, 6, 8, 7], [9, 10, 11, 12], [13, 14, 15, 16]]
        output = 100
        self.assertEqual(self.sol.maxCollectedFruits(fruits), output)

    def test_example2(self):
        fruits = [[1, 1], [1, 1]]
        output = 4
        self.assertEqual(self.sol.maxCollectedFruits(fruits), output)
