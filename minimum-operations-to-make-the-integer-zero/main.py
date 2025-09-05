class Solution:
    def makeTheIntegerZero(self, num1: int, num2: int) -> int:
        for k in range(1, 60 + 1):
            if num1 - num2 * k < k:
                break
            if (num1 - num2 * k).bit_count() <= k:
                return k
        return -1
