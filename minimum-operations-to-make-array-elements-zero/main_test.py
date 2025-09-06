import unittest

from main import Solution


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()
        return super().setUp()

    def test_example1(self):
        queries = [[1, 2], [2, 4]]
        output = 3
        self.assertEqual(self.solution.minOperations(queries), output)

    def test_example2(self):
        queries = [[2, 6]]
        output = 4
        self.assertEqual(self.solution.minOperations(queries), output)

    def test_ng1(self):
        queries = [[1, 8]]
        output = 7
        self.assertEqual(self.solution.minOperations(queries), output)
