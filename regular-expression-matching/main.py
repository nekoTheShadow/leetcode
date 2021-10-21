class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        if len(p) == 0:
            return len(s) == 0
        if len(s) == 0:
            return len(p) > 1 and p[1] == '*' and self.isMatch(s, p[2:])
        
        if len(p) > 1 and p[1] == '*':
            if s[0] == p[0] or p[0] == '.':
                return self.isMatch(s[1:], p) or self.isMatch(s, p[2:])
            else:
                return self.isMatch(s, p[2:])
        else:
            return (s[0] == p[0] or p[0] == '.') and self.isMatch(s[1:], p[1:])

s = input()
p = input()
if Solution().isMatch(s, p):
    print("true")
else:
    print("false")
