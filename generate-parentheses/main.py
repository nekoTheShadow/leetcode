from typing import List
import unittest


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        stack = [""]
        ans = []
        while stack:
            s = stack.pop()
            l = s.count("(")
            r = s.count(")")
            if l == n and r == n:
                ans.append(s)
            else:
                if l < n:
                    stack.append(s + "(")
                if l > r:
                    stack.append(s + ")")
        return ans

class TestSolution(unittest.TestCase):
    def test_example1(self):
        self.helper(3, ["((()))","(()())","(())()","()(())","()()()"])

    def test_example2(self):
        self.helper(1, ["()"])
    
    def helper(self, n: int, want: List[str]):
        self.assertEqual(set(want), set(Solution().generateParenthesis(n)))

if __name__ == '__main__':
    unittest.main()