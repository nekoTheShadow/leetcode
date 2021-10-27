from typing import List
import unittest

class Solution:
    def maxArea(self, height: List[int]) -> int:
        i = 0
        j = len(height)-1
        ans = 0
        while i < j:
            ans = max(ans, (j-i)*min(height[i], height[j]))
            if height[i] <= height[j]:
                i += 1
            else:
                j -= 1
        return ans


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_example1(self):
        self.assertEqual(self.solution.maxArea([1,8,6,2,5,4,8,3,7]), 49)

    def test_example2(self):
        self.assertEqual(self.solution.maxArea([1, 1]), 1)
    
    def test_example3(self):
        self.assertEqual(self.solution.maxArea([4,3,2,1,4]), 16)

    def test_example4(self):
        self.assertEqual(self.solution.maxArea([1, 2, 1]), 2)


if __name__ == '__main__':
    unittest.main()