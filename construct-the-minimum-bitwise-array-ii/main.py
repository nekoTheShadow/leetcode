from typing import List
import unittest


class Solution:
    def minBitwiseArray(self, nums: List[int]) -> List[int]:
        return [solve(n) for n in nums]


def solve(n: int) -> int:
    if n == 2:
        return -1
    i = 0
    while n & (1 << i) != 0:
        i += 1
    return n ^ (1 << (i - 1))


class SolutionTest(unittest.TestCase):
    def setUp(self) -> None:
        self.solution = Solution()

    def test_example1(self) -> None:
        nums = [2, 3, 5, 7]
        output = [-1, 1, 4, 3]
        self.assertEqual(self.solution.minBitwiseArray(nums), output)

    def test_example2(self) -> None:
        nums = [11, 13, 31]
        output = [9, 12, 15]
        self.assertEqual(self.solution.minBitwiseArray(nums), output)
