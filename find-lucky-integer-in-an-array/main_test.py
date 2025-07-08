import unittest

from main import Solution


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_example1(self):
        self.assertEqual(self.solution.findLucky([2, 2, 3, 4]), 2)

    def test_example2(self):
        self.assertEqual(self.solution.findLucky([1, 2, 2, 3, 3, 3]), 3)

    def test_example3(self):
        self.assertEqual(self.solution.findLucky([2, 2, 2, 3, 3]), -1)
