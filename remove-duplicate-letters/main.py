import bisect
import collections


class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        count = collections.Counter(s)
        stack = []
        for ch in s:
            count[ch] -= 1
            if ch in stack:
                continue
            while stack and ch<stack[-1] and count[stack[-1]] > 0:
                stack.pop()
            stack.append(ch)
        return ''.join(stack)


if __name__ == '__main__':
    print(Solution().removeDuplicateLetters("bcabc"))
    print(Solution().removeDuplicateLetters("cbacdcbc"))