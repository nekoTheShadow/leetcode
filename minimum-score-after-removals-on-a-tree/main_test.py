import unittest

from main import Solution


class TestSolution(unittest.TestCase):
    def setUp(self) -> None:
        self.solution = Solution()

    def test_example1(self) -> None:
        nums = [1, 5, 5, 4, 11]
        edges = [[0, 1], [1, 2], [1, 3], [3, 4]]
        output = 9
        self.assertEqual(self.solution.minimumScore(nums, edges), output)

    def test_example2(self) -> None:
        nums = [5, 5, 2, 4, 4, 2]
        edges = [[0, 1], [1, 2], [5, 2], [4, 3], [1, 3]]
        output = 0
        self.assertEqual(self.solution.minimumScore(nums, edges), output)
