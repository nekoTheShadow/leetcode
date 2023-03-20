

from typing import List


class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        x = len(flowerbed)
        for i in range(x):
            pre = flowerbed[i-1] if 0<=i-1<x else 0
            cur = flowerbed[i]
            nxt = flowerbed[i+1] if 0<=i+1<x else 0
            if pre==0 and cur==0 and nxt==0:
                flowerbed[i] = 1
                n -= 1
        return n <= 0

if __name__ == '__main__':
    print(Solution().canPlaceFlowers([1,0,0,0,1], 1))
    print(Solution().canPlaceFlowers([1,0,0,0,1], 2))
    print(Solution().canPlaceFlowers([1,0,0,0,0,1], 2))