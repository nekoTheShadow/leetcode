import unittest

from main import Solution


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.sol = Solution()

    def test_example1(self):
        nums = [1, 2, 3, 4]
        expected = 4
        result = self.sol.maximumLength(nums)
        self.assertEqual(
            result,
            expected,
        )

    def test_example2(self):
        nums = [1, 2, 1, 1, 2, 1, 2]
        expected = 6
        result = self.sol.maximumLength(nums)
        self.assertEqual(
            result,
            expected,
        )

    def test_example3(self):
        nums = [1, 3]
        expected = 2
        result = self.sol.maximumLength(nums)
        self.assertEqual(
            result,
            expected,
        )
