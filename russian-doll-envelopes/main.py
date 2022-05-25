import bisect
import operator
from typing import List


class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        a = list(map(operator.itemgetter(1), envelopes))
        b = []
        for i in range(len(a)):
            x = bisect.bisect_left(b, a[i])
            if len(b) == x:
                b.append(a[i])
            else:
                b[x] = a[i]
        return len(b)

if __name__ == '__main__':
    print(Solution().maxEnvelopes([[5,4],[6,4],[6,7],[2,3]]))
    print(Solution().maxEnvelopes([[1,1],[1,1],[1,1]]))
    print(Solution().maxEnvelopes([[4,5],[4,6],[6,7],[2,3],[1,1]]))