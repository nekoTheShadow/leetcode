import unittest

from main import Solution


class TestSolution(unittest.TestCase):
    def test_example1(self):
        self.assertEqual(Solution().minOperations([1, 1, 4, 2, 3], 5), 2)

    def test_example2(self):
        self.assertEqual(Solution().minOperations([5, 6, 7, 8, 9], 4), -1)

    def test_example3(self):
        self.assertEqual(Solution().minOperations([3, 2, 20, 1, 1, 3], 10), 5)
