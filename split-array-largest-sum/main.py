

from typing import List


class Solution:
    def splitArray(self, nums: List[int], m: int) -> int:
        n = len(nums)
        self.s = [0] * (n+1)
        for i in range(n):
            self.s[i+1] = self.s[i] + nums[i]
        
        self.nums = nums
        self.m = m
        self.memo = {}
        return self.f(0, 0)

    def f(self, x: int, n: int) -> int:
        if x == len(self.nums):
            return 0

        if n == self.m-1:
            return self.s[len(self.s)-1]-self.s[x]
        
        key = (x, n)
        if key in self.memo:
            return self.memo[key]

        ans = float('inf')
        for y in range(x+1, len(self.nums)+1):
            left = self.s[y]-self.s[x]
            right = self.f(y, n+1)
            ans = min(ans, max(left, right))
            if left > right:
                break
                
        self.memo[key] = ans
        return ans

if __name__ == '__main__':
    print(Solution().splitArray([7,2,5,10,8], 2))
    print(Solution().splitArray([1,2,3,4,5], 2))
    print(Solution().splitArray([1,4,4], 3))
