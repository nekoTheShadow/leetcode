import unittest

from main import Solution


class TestSolution(unittest.TestCase):
    def setUp(self) -> None:
        self.sol = Solution()

    def test_example1(self) -> None:
        self.assertEqual(self.sol.maximumLength([1, 2, 3, 4, 5], 2), 5)

    def test_example2(self) -> None:
        self.assertEqual(self.sol.maximumLength([1, 4, 2, 3, 1, 4], 3), 4)

    def test_ng1(self) -> None:
        self.assertEqual(self.sol.maximumLength([1, 2, 3, 10, 2], 6), 3)
