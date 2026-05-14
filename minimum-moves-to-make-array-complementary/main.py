import unittest


class Solution:
    def minMoves(self, nums: list[int], limit: int) -> int:
        n = len(nums)

        diff = [0] * (2 * limit + 2)
        for i in range(n // 2):
            a = min(nums[i], nums[n - i - 1])
            b = max(nums[i], nums[n - i - 1])

            diff[2] += 2
            diff[2 * limit + 1] -= 2

            diff[a + 1] -= 1
            diff[b + limit + 1] += 1

            diff[a + b] -= 1
            diff[a + b + 1] += 1

        cur = 0
        ret = 10**9
        for i in range(2, 2 * limit + 1):
            cur += diff[i]
            ret = min(ret, cur)
        return ret


class TestSolution(unittest.TestCase):
    def setUp(self) -> None:
        self.s = Solution()

    def test_example1(self):
        nums = [1, 2, 4, 3]
        limit = 4
        output = 1
        self.assertEqual(self.s.minMoves(nums, limit), output)

    def test_example2(self):
        nums = [1, 2, 2, 1]
        limit = 2
        output = 2
        self.assertEqual(self.s.minMoves(nums, limit), output)

    def test_example3(self):
        nums = [1, 2, 1, 2]
        limit = 2
        output = 0
        self.assertEqual(self.s.minMoves(nums, limit), output)
