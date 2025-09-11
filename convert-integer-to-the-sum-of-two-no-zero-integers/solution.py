def has_zero(n: int) -> bool:
    while n > 0:
        if n % 10 == 0:
            return True
        n //= 10
    return False

class Solution:
    def getNoZeroIntegers(self, n: int) -> list[int]:
        for a in range(1, n):
            b = n - a
            if not has_zero(a) and not has_zero(b):
                return [a, b]
        
