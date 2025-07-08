import unittest

from solution import Solution


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_example1(self):
        self.assertEqual(self.solution.kthCharacter(5), "b")

    def test_example2(self):
        self.assertEqual(self.solution.kthCharacter(10), "c")
