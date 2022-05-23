from typing import List



class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        self.strs = strs
        self.m = m
        self.n = n
        self.memo = {}
        return self.f(0, 0, 0)

    def f(self, cur: int, zero: int, one: int) -> int:
        if not (zero <= self.m and one <= self.n):
            return float('-inf')
        
        if cur == len(self.strs):
            return 0

        key = (cur, zero, one)
        if key in self.memo:
            return self.memo[key]

        a = self.f(cur+1, zero+self.strs[cur].count('0'), one+self.strs[cur].count('1')) + 1
        b = self.f(cur+1, zero, one)
        self.memo[key] = max(a, b)
        return self.memo[key]

if __name__ == '__main__':
    print(Solution().findMaxForm(["10","0001","111001","1","0"], 5, 3))
    print(Solution().findMaxForm(["10","0","1"], 1, 1))