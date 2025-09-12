import unittest

from solution import Solution


class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()
        return super().setUp()

    def test_example1(self):
        self.assertTrue(self.solution.doesAliceWin("leetcoder"))

    def test_example2(self):
        self.assertFalse(self.solution.doesAliceWin("bbcd"))
