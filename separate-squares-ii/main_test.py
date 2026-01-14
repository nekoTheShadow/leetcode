import unittest

from main import Solution


class SolutionTest(unittest.TestCase):
    def test_example1(self):
        squares = [[0, 0, 1], [2, 2, 1]]
        output = 1.00000
        self.assertAlmostEqual(
            Solution().separateSquares(squares), output, delta=10**-5
        )

    def test_example2(self):
        squares = [[0, 0, 2], [1, 1, 1]]
        output = 1.00000
        self.assertAlmostEqual(
            Solution().separateSquares(squares), output, delta=10**-5
        )
