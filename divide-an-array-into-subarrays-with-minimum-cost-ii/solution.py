# pyright: reportOperatorIssue=false
# pyright: reportUnknownMemberType=false
# pyright: reportUnknownArgumentType=false
# pyright: reportArgumentType=false

from sortedcontainers import SortedList
import unittest


class MySet:

    def __init__(self, size: int) -> None:
        self.size = size
        self.total = 0
        self.st1: SortedList = SortedList()
        self.st2: SortedList = SortedList()

    def push(self, value: int):
        if len(self.st1) < self.size:
            self._add_st1(value)
            return

        if value < self.st1[-1]:
            self.st2.add(self.st1[-1])
            self._remove_st1(self.st1[-1])
            self._add_st1(value)
        else:
            self.st2.add(value)

    def remove(self, value: int):
        if value in self.st1:
            self._remove_st1(value)
            if self.st2:
                self._add_st1(self.st2.pop(0))
        else:
            self.st2.remove(value)

    def _add_st1(self, value: int):
        self.st1.add(value)
        self.total += value

    def _remove_st1(self, value: int):
        self.st1.remove(value)
        self.total -= value

    def get_total(self) -> int:
        return self.total

    def is_full(self) -> bool:
        return len(self.st1) == self.size


class Solution:
    def minimumCost(self, nums: list[int], k: int, dist: int) -> int:
        n = len(nums)

        ms = MySet(k - 2)
        for x in range(2, 2 + dist):
            ms.push(nums[x])

        ret = int(1e20)
        for x in range(1, n):
            if ms.is_full():
                ret = min(ret, nums[0] + nums[x] + ms.get_total())

            if x + dist + 1 < n:
                ms.push(nums[x + dist + 1])
            if x + 1 < n:
                ms.remove(nums[x + 1])
        return ret


class TestSolution(unittest.TestCase):
    def setUp(self) -> None:
        self.sol = Solution()

    def test_example1(self):
        nums = [1, 3, 2, 6, 4, 2]
        k = 3
        dist = 3
        output = 5
        self.assertEqual(self.sol.minimumCost(nums, k, dist), output)

    def test_example2(self):
        nums = [10, 1, 2, 2, 2, 1]
        k = 4
        dist = 3
        output = 15
        self.assertEqual(self.sol.minimumCost(nums, k, dist), output)

    def test_example3(self):
        nums = [10, 8, 18, 9]
        k = 3
        dist = 1
        output = 36
        self.assertEqual(self.sol.minimumCost(nums, k, dist), output)
