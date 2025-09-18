import math

class Solution:
    def replaceNonCoprimes(self, nums: list[int]) -> list[int]:
        stack: list[int] = []
        for num in nums:
            cur = num
            while stack and math.gcd(stack[-1], cur) != 1:
                cur = math.lcm(stack.pop(), cur)
            stack.append(cur)
        return stack
