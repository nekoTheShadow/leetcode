import unittest

from main import Solution


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_example1(self):
        self.assertTrue(self.solution.isValid("234Adas"))

    def test_example2(self):
        self.assertFalse(self.solution.isValid("b3"))

    def test_example3(self):
        self.assertFalse(self.solution.isValid("a3"))
