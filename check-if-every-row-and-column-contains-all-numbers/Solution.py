from threading import main_thread
from typing import List
import unittest


class Solution:
    def checkValid(self, matrix: List[List[int]]) -> bool:
        return all(map(self.ok, matrix)) and all(map(self.ok, self.transpose(matrix)))

    def transpose(self, matrix: List[List[int]]) -> List[List[int]]:
        n = len(matrix)
        return [[matrix[i][j] for i in range(n)] for j in range(n)]

    def ok(self, row: List[int]) -> bool:
        return len(row) == len(set(row))

class TestSolution(unittest.TestCase):
    def test_example1(self):
        self.assertTrue(Solution().checkValid([[1,2,3],[3,1,2],[2,3,1]]))

    def test_example2(self):
        self.assertFalse(Solution().checkValid([[1,1,1],[1,2,3],[1,2,3]]))

if __name__ == '__main__':
    unittest.main()