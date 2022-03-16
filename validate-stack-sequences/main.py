from typing import List
import collections

class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        a = collections.deque(pushed)
        b = collections.deque(popped)
        stack = []

        while a or b:
            if stack and b and stack[-1] == b[0]:
                stack.pop()
                b.popleft()
            elif a:
                stack.append(a.popleft())
            else:
                break
        
        return not a and not b
    
if __name__ == '__main__':
    print(Solution().validateStackSequences([1,2,3,4,5], [4,5,3,2,1]))
    print(Solution().validateStackSequences([1,2,3,4,5], [4,3,5,1,2]))