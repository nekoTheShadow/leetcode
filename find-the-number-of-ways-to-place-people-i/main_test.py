import unittest

from main import Solution


class SolutionTest(unittest.TestCase):
    def test_example1(self):
        self.assertEqual(Solution().numberOfPairs([[1, 1], [2, 2], [3, 3]]), 0)

    def test_example2(self):
        self.assertEqual(Solution().numberOfPairs([[6, 2], [4, 4], [2, 6]]), 2)

    def test_example3(self):
        self.assertEqual(Solution().numberOfPairs([[3, 1], [1, 3], [1, 1]]), 2)
