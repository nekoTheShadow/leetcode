import itertools
from typing import List


class Solution:
    def maxFreeTime(
        self, eventTime: int, k: int, startTime: List[int], endTime: List[int]
    ) -> int:
        meetings = [(-1, 0), *zip(startTime, endTime), (eventTime, -1)]
        hours: list[int] = [
            s2 - e1 for (_s1, e1), (s2, _e2) in itertools.pairwise(meetings)
        ]

        n = len(hours)
        d = [0] * (n + 1)
        for i in range(n):
            d[i + 1] = d[i] + hours[i]

        return max(d[i + k + 1] - d[i] for i in range(n - k))
