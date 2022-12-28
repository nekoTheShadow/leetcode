
from typing import List


class Solution:
    def minStoneSum(self, piles: List[int], k: int) -> int:
        import heapq
        q = []
        for pile in piles:
            heapq.heappush(q, -pile)
        for _ in range(k):
            x = -heapq.heappop(q)
            y = x//2 if x % 2 == 0 else x//2+1
            heapq.heappush(q, -y)
        return sum(-v for v in q)


if __name__ == '__main__':
    print(Solution().minStoneSum([5,4,9], 2))
    print(Solution().minStoneSum([4,3,6,7], 3))