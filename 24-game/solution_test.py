import unittest

from solution import Solution


class SolutionTest(unittest.TestCase):
    def test_example1(self):
        self.assertTrue(Solution().judgePoint24([4, 1, 8, 7]))

    def test_example2(self):
        self.assertFalse(Solution().judgePoint24([1, 2, 1, 2]))

    def test_example3(self):
        self.assertTrue(Solution().judgePoint24([8, 1, 6, 6]))

    def test_example4(self):
        self.assertTrue(Solution().judgePoint24([8, 1, 6, 6]))
