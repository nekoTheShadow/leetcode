import itertools
from typing import List


class Solution(object):
    def minimumCost(self, cost: List[int]) -> int:
        return sum(a + b for (a, b, c) in itertools.zip_longest(*([iter(sorted(cost, reverse=True))]*3), fillvalue=0))

if __name__ == '__main__':
    print(Solution().minimumCost([1,2,3])) #=> 5
    print(Solution().minimumCost([6,5,7,9,2,2])) #=> 23
    print(Solution().minimumCost([5,5])) #=> 23
    print(Solution().minimumCost([8])) #=> 8