class Solution:
    def sumZero(self, n: int) -> list[int]:
        lst = []
        for v in range(1, n // 2 + 1):
            lst.append(v)
            lst.append(-v)
        if n % 2 != 0:
            lst.append(0)
        return lst
