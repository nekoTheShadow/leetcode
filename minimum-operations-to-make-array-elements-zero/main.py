def count_div_by_4(x: int):
    c = 0
    while x > 0:
        x //= 4
        c += 1
    return c


def count(l: int, r: int):
    l_n = count_div_by_4(l)
    r_n = count_div_by_4(r)

    if l_n == r_n:
        return (r - l + 1) * l_n

    ret = ((4**l_n - 1) - l + 1) * l_n
    for n in range(l_n + 1, r_n):
        lo = 4 ** (n - 1)
        hi = 4**n - 1
        ret += (hi - lo + 1) * n
    ret += (r - (4 ** (r_n - 1)) + 1) * r_n
    return ret


def ceil_div(x: int, y: int) -> int:
    if x % y == 0:
        return x // y
    else:
        return x // y + 1


class Solution:
    def minOperations(self, queries: list[list[int]]) -> int:
        ret = 0
        for query in queries:
            l = query[0]
            r = query[1]
            ret += ceil_div(count(l, r), 2)
        return ret
