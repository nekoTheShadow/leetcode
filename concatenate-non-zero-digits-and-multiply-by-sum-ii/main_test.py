import unittest

from main import Solution


class TestSolution(unittest.TestCase):
    def setUp(self) -> None:
        self.solution = Solution()

    def test_example1(self):
        s = "10203004"
        queries = [[0, 7], [1, 3], [4, 6]]
        output = [12340, 4, 9]
        self.assertEqual(self.solution.sumAndMultiply(s, queries), output)

    def test_example2(self):
        s = "1000"
        queries = [[0, 3], [1, 1]]
        output = [1, 0]
        self.assertEqual(self.solution.sumAndMultiply(s, queries), output)

    def test_example3(self):
        s = "9876543210"
        queries = [[0, 9]]
        output = [444444137]
        self.assertEqual(self.solution.sumAndMultiply(s, queries), output)
