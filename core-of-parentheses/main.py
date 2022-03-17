class Solution:
    def scoreOfParentheses(self, s: str) -> int:
        return self.f(s, 0, len(s)-1)
    
    def f(self, s: str, x: int, y: int) -> int:
        if x == y-1: 
            return 1
        
        stack = []
        ans = 0
        for i in range(x, y+1):
            if s[i] == '(':
                stack.append(i)
            else:
                j = stack.pop()
                if len(stack) == 0:
                    if j==x and i==y:
                        ans += self.f(s, x+1, y-1) * 2
                    else:
                        ans += self.f(s, j, i)
        return ans


if __name__ == '__main__':
    print(Solution().scoreOfParentheses("()"))
    print(Solution().scoreOfParentheses("(())"))
    print(Solution().scoreOfParentheses("()()"))
    print(Solution().scoreOfParentheses("(()(()))"))