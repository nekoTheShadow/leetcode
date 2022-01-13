from typing import List
import unittest

import bisect
import collections

class Solution(object):
    def getDistances(self, arr: List[int]) -> List[int]:
        d = collections.defaultdict(list)
        for i, v in enumerate(arr):
            d[v].append(i)
        
        e = {}
        for k, a in d.items():
            n = len(a)
            e[k] = [0] * (n+1)
            for i in range(n):
                e[k][i+1] = e[k][i] + a[i]
        
        ans = []
        for i, v in enumerate(arr):
            n = len(d[v])
            x = bisect.bisect_left(d[v], i)
            ans.append(x*i-(e[v][x]-e[v][0]) + (e[v][n]-e[v][x+1])-(n-x-1)*i)
        
        return ans

class TestSolution(unittest.TestCase):
    def test_example1(self):
        self.assertEqual(Solution().getDistances([2,1,3,1,2,3,3]), [4,2,7,2,4,4,5])
    
    def test_example2(self):
        self.assertEqual(Solution().getDistances([10,5,10,10]), [5,0,3,4])
    
if __name__ == '__main__':
    unittest.main()