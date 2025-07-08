import unittest

from solution import Solution


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_example1(self):
        self.assertEqual(self.solution.kthCharacter(5, [0, 0, 0]), "a")

    def test_example2(self):
        self.assertEqual(self.solution.kthCharacter(10, [0, 1, 0, 1]), "b")

    def test_ng1(self):
        self.assertEqual(self.solution.kthCharacter(3, [1, 0]), "a")
