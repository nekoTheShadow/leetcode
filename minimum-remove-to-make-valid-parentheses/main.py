import enum


class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        stack = []
        trash = set()
        for x, ch in enumerate(s):
            if ch == '(':
                stack.append(x)
            if ch == ')':
                if stack:
                    stack.pop()
                else:
                    trash.add(x)
        trash.update(stack)
        return ''.join(ch for x, ch in enumerate(s) if not x in trash)

if __name__ == '__main__':
    print(Solution().minRemoveToMakeValid("lee(t(c)o)de)"))
    print(Solution().minRemoveToMakeValid("a)b(c)d")) 
    print(Solution().minRemoveToMakeValid("))((")) 