def odd(x: int) -> int:
    if x % 2 == 0:
        return x // 2
    else:
        return x // 2 + 1


def even(x: int) -> int:
    return x // 2


class Solution:
    def flowerGame(self, n: int, m: int) -> int:
        return odd(n) * even(m) + even(n) * odd(m)
