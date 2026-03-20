import math
from typing import List
import unittest


# 労働力work_timeの労働者がn秒で削れる山の高さ
def height(work_time: int, n: int) -> int:
    return int((math.isqrt(1 + (8 * n) // work_time) - 1) // 2)


class Solution:
    def minNumberOfSeconds(self, mountainHeight: int, workerTimes: List[int]) -> int:
        ok = int(1e18)
        ng = -1
        while abs(ok - ng) > 1:
            mi = (ok + ng) // 2
            if mountainHeight <= sum(
                height(worker_time, mi) for worker_time in workerTimes
            ):
                ok = mi
            else:
                ng = mi
        return ok


class TestSolution(unittest.TestCase):
    def test_example1(self):
        mountainHeight = 4
        workerTimes = [2, 1, 1]
        output = 3
        self.assertEqual(
            Solution().minNumberOfSeconds(mountainHeight, workerTimes), output
        )

    def test_example2(self):
        mountainHeight = 10
        workerTimes = [3, 2, 2, 4]
        output = 12
        self.assertEqual(
            Solution().minNumberOfSeconds(mountainHeight, workerTimes), output
        )

    def test_example3(self):
        mountainHeight = 5
        workerTimes = [1]
        output = 15
        self.assertEqual(
            Solution().minNumberOfSeconds(mountainHeight, workerTimes), output
        )

    def test_NG1(self):
        mountainHeight = 100000
        workerTimes = [1]
        output = 5000050000
        self.assertEqual(
            Solution().minNumberOfSeconds(mountainHeight, workerTimes), output
        )

    def test_NG2(self):
        mountainHeight = 100000
        workerTimes = [1000000]
        output = 5000050000000000
        self.assertEqual(
            Solution().minNumberOfSeconds(mountainHeight, workerTimes), output
        )
