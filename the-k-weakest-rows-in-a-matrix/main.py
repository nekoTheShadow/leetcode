import operator
from typing import List


class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        return list(map(operator.itemgetter(1), sorted((v.count(1), i) for i, v in enumerate(mat))))[:k]

if __name__ == '__main__':
    print(Solution().kWeakestRows([[1,0,0,0],[1,1,1,1],[1,0,0,0],[1,0,0,0]], 2))
    print(Solution().kWeakestRows([[1,1,0,0,0],[1,1,1,1,0],[1,0,0,0,0],[1,1,0,0,0],[1,1,1,1,1]], 3))