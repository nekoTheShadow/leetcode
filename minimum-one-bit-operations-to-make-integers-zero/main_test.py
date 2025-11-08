import unittest

from main import Solution


class SolutionTest(unittest.TestCase):
    def setUp(self) -> None:
        self.solution = Solution()

    def test_example1(self) -> None:
        self.assertEqual(self.solution.minimumOneBitOperations(3), 2)

    def test_example2(self) -> None:
        self.assertEqual(self.solution.minimumOneBitOperations(6), 4)

    def test_ng1(self) -> None:
        self.assertEqual(self.solution.minimumOneBitOperations(9), 14)
