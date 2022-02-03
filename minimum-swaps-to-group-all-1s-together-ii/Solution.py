from typing import List
import unittest


class Solution(object):
    def minSwaps(self, nums: List[int]) -> int:
        n = len(nums)
        s = [0] * (n+1)
        for i in range(n):
            s[i+1] = s[i] + nums[i]
        
        ans = float('inf')
        m = nums.count(1)
        for i in range(n):
            if i+m <= n:
                ans = min(ans, m - (s[i+m] - s[i]))
        
        l = n - m
        for i in range(n):
            if i+l <= n:
                ans = min(ans, s[i+l] - s[i])

        return ans


class TestSolution(unittest.TestCase):
    def test_example1(self):
        self.assertEqual(Solution().minSwaps([0,1,0,1,1,0,0]), 1)
    
    def test_example2(self):
        self.assertEqual(Solution().minSwaps([0,1,1,1,0,0,1,1,0]), 2)
    
    def test_example3(self):
        self.assertEqual(Solution().minSwaps([1,1,0,0,1]), 0)

if __name__ == '__main__':
    unittest.main()