import unittest
from typing import List

class Solution(object):
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        ans = 0
        satisfaction.sort()
        for i in range(len(satisfaction)):
            total = sum((x+1)*v for x, v in enumerate(satisfaction[i:]))
            ans = max(ans, total)
        return ans


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_example1(self):
        self.assertEqual(self.solution.maxSatisfaction([-1,-8,0,5,-9]), 14)
    
    def test_example2(self):
        self.assertEqual(self.solution.maxSatisfaction([4,3,2]), 20)

    def test_example3(self):
        self.assertEqual(self.solution.maxSatisfaction([-1,-4,-5]), 0)

    def test_example4(self):
        self.assertEqual(self.solution.maxSatisfaction([-2,5,-1,0,3,-3]), 35)