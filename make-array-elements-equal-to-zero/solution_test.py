import unittest

from solution import Solution


class TestSolution(unittest.TestCase):
    def setUp(self) -> None:
        self.solution = Solution()

    def test_example1(self) -> None:
        nums = [1, 0, 2, 0, 3]
        output = 2
        self.assertEqual(self.solution.countValidSelections(nums), output)

    def test_example2(self) -> None:
        nums = [2, 3, 4, 0, 4, 1, 0]
        output = 0
        self.assertEqual(self.solution.countValidSelections(nums), output)
