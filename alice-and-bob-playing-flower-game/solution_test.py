import unittest

from solution import Solution


class SolutionTest(unittest.TestCase):
    def test_example1(self):
        self.assertEqual(Solution().flowerGame(3, 2), 3)

    def test_example2(self):
        self.assertEqual(Solution().flowerGame(1, 1), 0)
