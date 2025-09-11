# i-forget+1 <= x <= i-delay の合計が増える
# n-forget <= x <= n-1 の合計が答え

def total(d: list[int], lo: int, hi: int) -> int:
    tot = 0
    for i in range(lo, hi + 1):
        if 0 <= i < len(d):
            tot += d[i]
            tot %= 10 ** 9 + 7
    return tot

class Solution:
    def peopleAwareOfSecret(self, n: int, delay: int, forget: int) -> int:
        d = [1]
        for i in range(1, n):
            d.append(total(d, i-forget+1, i-delay))
        return total(d, n-forget, n-1)
