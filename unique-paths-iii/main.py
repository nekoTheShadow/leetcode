from typing import List
import unittest
import itertools

class Solution(object):
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        n = len(grid)
        m = len(grid[0])
        count = 0
        for x, y in itertools.product(range(n), range(m)):
            if grid[x][y] != -1:
                count += 1

            if grid[x][y] == 1:
                startX = x
                startY = y
            elif grid[x][y] == 2:
                goalX = x
                goalY = y

        stack = [(startX, startY, set())]
        ans = 0
        diffs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        while stack:
            x, y, history = stack.pop()
            if x == goalX and y == goalY:
                if len(history) == count - 1:
                    ans += 1
                continue
            
            for dx, dy in diffs:
                nx = x + dx
                ny = y + dy
                if 0 <= nx < n and 0 <= ny < m and grid[nx][ny] != -1 and not (nx, ny) in history:
                    nextHistory = set(history)
                    nextHistory.add((x, y))
                    stack.append((nx, ny, nextHistory))
        
        return ans
        


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()
    
    def test_example1(self):
        self.assertEqual(self.solution.uniquePathsIII([[1,0,0,0],[0,0,0,0],[0,0,2,-1]]), 2)
    
    def test_example2(self):
        self.assertEqual(self.solution.uniquePathsIII([[1,0,0,0],[0,0,0,0],[0,0,0,2]]), 4)
    
    def test_example3(self):
        self.assertEqual(self.solution.uniquePathsIII([[0,1],[2,0]]), 0)