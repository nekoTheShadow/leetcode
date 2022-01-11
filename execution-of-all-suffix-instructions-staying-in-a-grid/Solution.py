from typing import List
import unittest

class Solution:
    def executeInstructions(self, n: int, startPos: List[int], s: str) -> List[int]:
        self.n = n
        self.start_x = startPos[0]
        self.start_y = startPos[1]
        self.diffs = {
            'L' : (0, -1),
            'R' : (0,  1),
            'U' : (-1, 0),
            'D' : (1,  0)
        }
        return [self.solve(s[i:]) for i in range(len(s))]

    def solve(self, s: str) -> int:
        x = self.start_x
        y = self.start_y
        count = 0
        for c in s:
            (dx, dy) = self.diffs[c]
            if not (0 <= x+dx < self.n and 0 <= y+dy < self.n):
                break
            x += dx
            y += dy
            count += 1
        return count


class TestSolution(unittest.TestCase):
    def test_example1(self):
        self.assertEqual(Solution().executeInstructions(3, [0, 1], "RRDDLU"), [1,5,4,3,1,0])

    def test_example2(self):
        self.assertEqual(Solution().executeInstructions(2, [1, 1], "LURD"), [4,1,0,0])

    def test_example3(self):
        self.assertEqual(Solution().executeInstructions(1, [0, 0], "LRUD"), [0,0,0,0])

if __name__ == '__main__':
    unittest.main()