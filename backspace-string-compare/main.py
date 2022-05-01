class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        return self.clean(s) == self.clean(t)

    def clean(self, s: str) -> str:
        stack = []
        for ch in s:
            if ch == '#':
                if stack:
                    stack.pop()
            else:
                stack.append(ch)
        return ''.join(stack)

if __name__ == '__main__':
    print(Solution().backspaceCompare("ab#c", "ad#c"))
    print(Solution().backspaceCompare("ab##", "c#d#"))
    print(Solution().backspaceCompare("a#c", "b"))