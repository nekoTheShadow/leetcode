import unittest

from solution import Solution


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_example1(self):
        self.assertEqual(self.solution.possibleStringCount("abbcccc"), 5)

    def test_example2(self):
        self.assertEqual(self.solution.possibleStringCount("abcd"), 1)

    def test_example3(self):
        self.assertEqual(self.solution.possibleStringCount("aaaa"), 4)


if __name__ == "__main__":
    unittest.main()
