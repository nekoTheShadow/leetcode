from typing import List
import unittest, itertools, collections

class Solution:
    def fourSumCount(self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]) -> int:
        c1 = collections.Counter(v1+v2 for v1, v2 in itertools.product(nums1, nums2))
        c2 = collections.Counter(v3+v4 for v3, v4 in itertools.product(nums3, nums4))
        return sum(c1[k1]*c2[-k1] for k1 in c1)

class TestSolution(unittest.TestCase):
    def test_example1(self):
        nums1 = [1,2]
        nums2 = [-2,-1]
        nums3 = [-1,2]
        nums4 = [0,2]
        self.assertEqual(Solution().fourSumCount(nums1, nums2, nums3, nums4), 2)
    
    def test_example2(self):
        nums1 = [0]
        nums2 = [0]
        nums3 = [0]
        nums4 = [0]
        self.assertEqual(Solution().fourSumCount(nums1, nums2, nums3, nums4), 1)

if __name__ == '__main__':
    unittest.main()