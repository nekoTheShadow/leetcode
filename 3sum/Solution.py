from typing import List
import unittest

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        import bisect
        
        nums.sort()
        n = len(nums)

        triplets = set()
        for i in range(n):
            for j in range(i+1, n):
                k = bisect.bisect_left(nums, (nums[i]+nums[j])*-1, lo=j+1)
                if k < n and nums[i]+nums[j]+nums[k] == 0:
                    triplets.add((nums[i], nums[j], nums[k]))
        return list(map(list, triplets))


class TestSolution(unittest.TestCase):
    def test_example1(self):
        expected = set(tuple(sorted(triplet)) for triplet in [[-1,-1,2],[-1,0,1]])
        actual = set(tuple(sorted(triplet)) for triplet in Solution().threeSum([-1,0,1,2,-1,-4]))
        self.assertSetEqual(expected, actual)
    
    def test_example2(self):
        self.assertEqual(Solution().threeSum([]), [])

    def test_example3(self):
        self.assertEqual(Solution().threeSum([0]), [])

if __name__ == '__main__':
    unittest.main()